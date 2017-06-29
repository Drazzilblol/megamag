package by.instinctools.megamag.common.utils;


import android.content.res.Resources;

public final class ScreenUtils {

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
