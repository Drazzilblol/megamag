package by.instinctools.megamag;

import android.content.Context;

import by.instinctools.megamag.common.SharedPrefs;
import timber.log.Timber;

public class Application extends android.app.Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SharedPrefs.initSharedPrefs(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static Context getAppContext() {
        return context;
    }

}
