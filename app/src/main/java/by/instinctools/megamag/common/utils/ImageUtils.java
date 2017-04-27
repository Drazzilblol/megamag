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
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;

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
}
