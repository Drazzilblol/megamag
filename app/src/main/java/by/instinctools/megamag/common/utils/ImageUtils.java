package by.instinctools.megamag.common.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;

import by.instinctools.megamag.R;

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
        if (!TextUtils.isEmpty(image)) {
            imageView.setVisibility(View.VISIBLE);

            Glide.with(context)
                    .load(image)
                    .bitmapTransform(new BlurAndCropTransformation(context))
                    .placeholder(R.drawable.loading_placeholder)
                    .error(R.drawable.no_image_found)
                    .into(imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }

    public static void loadImageWithBlur(@NonNull Context context, @NonNull ImageView imageView, @Nullable String image, @Nullable String imageLQ) {
        if (!TextUtils.isEmpty(image)) {
            imageView.setVisibility(View.VISIBLE);

            Glide.with(context)
                    .load(image)
                    .bitmapTransform(new BlurAndCropTransformation(context))
                    .placeholder(R.drawable.loading_placeholder)
                    .error(R.drawable.no_image_found)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            Glide.with(context).load(imageLQ)
                                    .bitmapTransform(new BlurAndCropTransformation(context))
                                    .placeholder(R.drawable.loading_placeholder)
                                    .error(R.drawable.no_image_found)
                                    .into(target);
                            return true;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
    }
}
