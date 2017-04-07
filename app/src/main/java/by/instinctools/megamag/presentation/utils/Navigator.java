package by.instinctools.megamag.presentation.utils;

import android.content.Context;
import android.content.Intent;

import by.instinctools.megamag.presentation.tickets.TicketsActivity;

public final class Navigator {
    public static void goToTicketsScreen(Context context) {
        Intent i = new Intent(context, TicketsActivity.class);
        context.startActivity(i);
    }
}
