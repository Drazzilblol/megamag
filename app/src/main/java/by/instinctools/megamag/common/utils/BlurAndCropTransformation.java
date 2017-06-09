package by.instinctools.megamag.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class BlurAndCropTransformation extends BitmapTransformation {

    private BlurTransformation blur;

    public BlurAndCropTransformation(Context context) {
        super(context);
        blur = new BlurTransformation(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap srcBitmap = toTransform;
        if (srcBitmap.getWidth() > outWidth && srcBitmap.getHeight() > outHeight) {
            srcBitmap = resizeBitmap(srcBitmap, outWidth, outHeight);
        }
        try {
            return addBackgroundBlur(srcBitmap, pool, outWidth, outHeight);
        } finally {
            if (srcBitmap != toTransform) {
                srcBitmap.recycle();
            }
        }
    }

    private Bitmap resizeBitmap(Bitmap toTransform, int outWidth, int outHeight) {

        float bmWidth = toTransform.getWidth();
        float bmHeight = toTransform.getHeight();

        float widthDiff = bmWidth / outWidth;
        float heightDiff = bmHeight / outHeight;

        int resWidth;
        int resHeight;

        if (widthDiff > heightDiff) {
            resWidth = (int) (bmWidth / heightDiff);
            resHeight = (int) (bmHeight / heightDiff);
        } else {
            resWidth = (int) (bmWidth / widthDiff);
            resHeight = (int) (bmHeight / widthDiff);
        }

        return Bitmap.createScaledBitmap(toTransform, resWidth, resHeight, true);
    }

    @Override
    public String getId() {
        return BlurAndCropTransformation.class.getName();
    }

    @NonNull
    private Bitmap addBackgroundBlur(@NonNull Bitmap bitmap, BitmapPool pool, int outWidth, int outHeight) {
        Bitmap cropped = cropDrawable(bitmap, outWidth, outHeight);

        Bitmap blurred = blur.transform(BitmapResource.obtain(cropped, pool),
                cropped.getWidth(),
                cropped.getHeight())
                .get();
        cropped.recycle();

        float width = blurred.getHeight() * ((float) bitmap.getWidth() / bitmap.getHeight());
        Bitmap scaledSrcBitmap = Bitmap.createScaledBitmap(
                bitmap,
                (int) width,
                blurred.getHeight(),
                true);
        Canvas canvas = new Canvas(blurred);
        canvas.drawBitmap(scaledSrcBitmap, blurred.getWidth() / 2 - scaledSrcBitmap.getWidth() / 2, 0f, null);
        scaledSrcBitmap.recycle();
        return blurred;
    }

    private static Bitmap cropDrawable(@NonNull Bitmap source, int outWidth, int outHeight) {
        float aspectRatio = (float) outWidth / outHeight;
        Bitmap bitmap;
        if (source.getWidth() >= source.getHeight()) {
            bitmap = Bitmap.createBitmap(
                    source,
                    source.getWidth() / 2 - source.getHeight() / 2,
                    0,
                    source.getHeight(),
                    (int) (source.getHeight() / aspectRatio)
            );
        } else {
            bitmap = Bitmap.createBitmap(
                    source,
                    0,
                    source.getHeight() / 2 - source.getWidth() / 2,
                    source.getWidth(),
                    (int) (source.getWidth() / aspectRatio)
            );
        }
        return bitmap;
    }
}
