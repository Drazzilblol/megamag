package by.instinctools.megamag.data.preferences;

import by.instinctools.megamag.data.DataSource;
import io.reactivex.Observable;

interface PreferencesDataSource extends DataSource<String, String> {

    Observable<Integer> getInteger(String key);

    Observable<Integer> saveInteger(String key, Integer value);

    Observable<Float> getFloat(String key);

    Observable<Float> saveFloat(String key, Float value);

    Observable<Long> getLong(String key);

    Observable<Long> saveLong(String key, Long value);

    Observable<String> getString(String key);

    Observable<String> saveString(String key, String value);

    Observable<Boolean> getBoolean(String key);

    Observable<Boolean> saveBoolean(String key, Boolean value);

}
