package by.instinctools.megamag.common.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.DrawableRes;

public final class DrawableUtils {

    public static final int NO_URI_ID = 0;

    public static Uri getDrawableUri(@DrawableRes int uriId, Context context) {
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
