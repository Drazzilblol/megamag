package by.instinctools.megamag.common.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.concurrent.ExecutionException;

import by.instinctools.megamag.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public final class ImageUtils {

    public static final int NO_URI_ID = 0;

    public static void loadImage(@NonNull Context context, @NonNull ImageView imageView, @Nullable Uri imageUri) {
        if (imageUri != null && TextUtils.isEmpty(imageUri.toString())) {
            imageView.setVisibility(View.VISIBLE);
            if (imageUri.getScheme().contains(ContentResolver.SCHEME_ANDROID_RESOURCE)) {
                imageView.setImageURI(imageUri);
            } else {
                Glide.with(context)
                        .load(imageUri)
                        .into(imageView);
            }
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    public static void loadImage(@NonNull Context context, @NonNull ImageView imageView, @Nullable String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            imageView.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(imageUrl)
                    .into(imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    public static void loadImage(@NonNull Context context, @NonNull ImageView imageView, @Nullable File image) {
        if (image != null) {
            imageView.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(image)
                    .into(imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    @Nullable
    public static Uri getResourceUri(@NonNull Context context, @DrawableRes int uriId) {
        if (uriId > NO_URI_ID) {
            Resources resources = context.getResources();
            return Uri.parse(
                    ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + resources.getResourcePackageName(uriId)
                            + '/' + resources.getResourceTypeName(uriId)
                            + '/' + resources.getResourceEntryName(uriId)
            );
        } else {
            return null;
        }
    }

    public static void loadImageWithBlur(@NonNull Context context, @NonNull ImageView imageView, @Nullable String image) {
        if (image != null) {
            imageView.setVisibility(View.VISIBLE);

            Observable.defer(() -> Observable.just(getBitmap(context, image)))
                    .flatMap(Observable::just)
                    .map(ImageUtils::addBackgroundBlur)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            imageView::setImageBitmap,

                            throwable -> imageView.setImageResource(R.drawable.no_image_found)
                    );

        } else {
            imageView.setVisibility(View.GONE);
        }
    }


    @Nullable
    private static Bitmap getBitmap(@NonNull Context context, @Nullable String image) {
        Bitmap bitmap = null;
        try {
            bitmap = Glide.with(context)
                    .load(image)
                    .asBitmap()
                    .into(-1, -1)
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            Timber.e(e);
        }
        return bitmap;
    }

    @NonNull
    private static Bitmap addBackgroundBlur(@NonNull Bitmap bitmap) {
        Bitmap cropped = cropDrawable(bitmap);
        Bitmap blurred = blur(cropped, 7);
        cropped.recycle();
        Bitmap result = Bitmap.createBitmap(
                blurred,
                0,
                0,
                blurred.getWidth(),
                blurred.getHeight());

        blurred.recycle();
        float width = result.getHeight() * ((float) bitmap.getWidth() / bitmap.getHeight());
        Bitmap src = Bitmap.createScaledBitmap(
                bitmap,
                (int) width,
                result.getHeight(),
                true);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(src, result.getWidth() / 2 - src.getWidth() / 2, 0f, null);
        return result;
    }

    private static Bitmap cropDrawable(@NonNull Bitmap source) {
        Bitmap bitmap;
        if (source.getWidth() >= source.getHeight()) {
            bitmap = Bitmap.createBitmap(
                    source,
                    source.getWidth() / 2 - source.getHeight() / 2,
                    0,
                    source.getHeight(),
                    (int) (source.getHeight() / 1.76)
            );
        } else {
            bitmap = Bitmap.createBitmap(
                    source,
                    0,
                    source.getHeight() / 2 - source.getWidth() / 2,
                    source.getWidth(),
                    (int) (source.getWidth() / 1.76)
            );
        }
        return bitmap;
    }

    @NonNull
    private static Bitmap blur(@NonNull Bitmap sentBitmap, int radius) {
        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);

        if (radius < 1) {
            radius = 1;
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int[] pix = new int[w * h];
        Timber.e(w + " " + h + " " + pix.length);
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;

        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];

        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }

        yw = yi = 0;

        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;

        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;

            for (x = 0; x < w; x++) {

                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];

                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;

                sir = stack[i + radius];

                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];

                rbs = r1 - Math.abs(i);

                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;

                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }

                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = (0xff000000 & pix[yi]) | (dv[rsum] << 16) | (dv[gsum] << 8) | dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];

                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi += w;
            }
        }

        bitmap.setPixels(pix, 0, w, 0, 0, w, h);

        return (bitmap);
    }
}
