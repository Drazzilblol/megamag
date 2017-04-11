package by.instinctools.megamag.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

public class SharedPrefs {

    private static volatile SharedPrefs instance;
    private static volatile SharedPreferences sharedPreferences;

    public static void initSharedPrefs(@NonNull Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPrefs getInstance() {
        SharedPrefs result = instance;
        if (result == null) {
            synchronized (SharedPrefs.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SharedPrefs();
                }
            }
        }
        return result;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

}
