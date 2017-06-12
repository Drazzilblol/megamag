package by.instinctools.megamag.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
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
            srcBitmap = resizeBitmap(srcBitmap, pool, outWidth, outHeight);
        }
        try {
            return addBackgroundBlur(srcBitmap, pool, outWidth, outHeight);
        } finally {
            if (srcBitmap != toTransform) {
                srcBitmap.recycle();
            }
        }
    }

    private Bitmap resizeBitmap(Bitmap toTransform, BitmapPool pool, int outWidth, int outHeight) {

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

        return getBitmapFromPool(toTransform, pool, resWidth, resHeight);
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

        int width = (int) (blurred.getHeight() * ((float) bitmap.getWidth() / bitmap.getHeight()));
        Bitmap scaledSrcBitmap = getBitmapFromPool(bitmap, pool, width, blurred.getHeight());

        Canvas canvas = new Canvas(blurred);
        canvas.drawBitmap(scaledSrcBitmap, blurred.getWidth() / 2 - scaledSrcBitmap.getWidth() / 2, 0f, null);
        return blurred;
    }

    private Bitmap getBitmapFromPool(@NonNull Bitmap bitmap, BitmapPool pool, int width, int height) {
        Bitmap scaledSrcBitmap = pool.getDirty(width, height, null);
        if (scaledSrcBitmap == null) {
            scaledSrcBitmap = Bitmap.createScaledBitmap(
                    bitmap,
                    width,
                    height,
                    true);
            pool.put(scaledSrcBitmap);
        } else {
            Matrix matrix = new Matrix();
            matrix.setScale((float) scaledSrcBitmap.getWidth() / bitmap.getWidth(), (float) scaledSrcBitmap.getHeight() / bitmap.getHeight());

            Canvas canvas = new Canvas(scaledSrcBitmap);
            canvas.drawBitmap(bitmap, matrix, null);
        }
        return scaledSrcBitmap;
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
