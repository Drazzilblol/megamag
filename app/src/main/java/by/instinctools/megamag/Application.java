package by.instinctools.megamag;

import android.content.Context;

import by.instinctools.megamag.common.SharedPrefs;

public class Application extends android.app.Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SharedPrefs.initSharedPrefs(this);
    }

    public static Context getAppContext() {
        return context;
    }

}
