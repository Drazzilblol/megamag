package by.instinctools.megamag.common.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import by.instinctools.megamag.presentation.info.InfoActivity;
import by.instinctools.megamag.presentation.main.MainActivity;
import by.instinctools.megamag.presentation.profile.ProfileActivity;

public final class Navigator {

    public static void goToMainScreen(@NonNull Context context) {
        Intent i = MainActivity.createIntent(context);
        context.startActivity(i);
    }

    public static void goToProfileScreen(@NonNull Context context) {
        Intent i = ProfileActivity.createIntent(context);
        context.startActivity(i);
    }

    public static void goToInfoScreen(@NonNull Context context) {
        Intent i = InfoActivity.createIntent(context, "1");
        context.startActivity(i);
    }
}
