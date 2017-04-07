package by.instinctools.megamag.common.utils;

import android.content.Context;
import android.content.Intent;

import by.instinctools.megamag.presentation.main.MainActivity;


public final class Navigator {

    public static void goToMainScreen(Context context) {
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}
