package by.instinctools.megamag;

import by.instinctools.megamag.common.SharedPrefs;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefs.initSharedPrefs(this);
    }
}
