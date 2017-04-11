package by.instinctools.megamag.data.preferences;


import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.Map;

import by.instinctools.megamag.common.SharedPrefs;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

class LocalPreferencesDataSource implements PreferencesDataSource {

    private static final String DEF_VALUE = "1";

    @NonNull
    private SharedPreferences sharedPreferences;

    LocalPreferencesDataSource() {
        sharedPreferences = SharedPrefs.getInstance().getSharedPreferences();
    }

    @Override
    public Observable<String> getValue(@NonNull final String key) {
        return Observable.just(sharedPreferences)
                .map(s -> s.getString(key, DEF_VALUE));
    }

    @Override
    public Observable<String> saveValue(@NonNull final String key, @NonNull final String value) {
        return Observable.just(sharedPreferences)
                .map(SharedPreferences::edit)
                .map(editor -> editor.putString(key, value))
                .map(SharedPreferences.Editor::commit)
                .flatMap(r -> this.getValue(key));
    }

    @Override
    public Observable<Map<String, ?>> getAll() {
        return Observable.just(sharedPreferences).map(SharedPreferences::getAll);
    }

    @Override
    public Observable<Map<String, String>> saveAll(Map<String, String> collection) {
        Observable.just(sharedPreferences).map(new Function<SharedPreferences, String>() {
            @Override
            public String apply(SharedPreferences sharedPreferences) throws Exception {
                for (Map.Entry<String, String> entry : collection.entrySet()) {
                    saveValue(entry.getKey(), entry.getValue());
                }
                return null;
            }
        });
        return null;
    }


    @Override
    public Observable<Integer> getInteger(String key) {
        return getValue(key).map(Integer::parseInt);
    }

    @Override
    public Observable<Integer> saveInteger(String key, Integer value) {
        return saveValue(key, String.valueOf(value)).map(Integer::parseInt);
    }

    @Override
    public Observable<Float> getFloat(String key) {
        return getValue(key).map(Float::parseFloat);
    }

    @Override
    public Observable<Float> saveFloat(String key, Float value) {
        return saveValue(key, value.toString()).map(Float::parseFloat);
    }

    @Override
    public Observable<Long> getLong(String key) {
        return getValue(key).map(Long::parseLong);
    }

    @Override
    public Observable<Long> saveLong(String key, Long value) {
        return saveValue(key, value.toString()).map(Long::parseLong);
    }

    @Override
    public Observable<String> getString(String key) {
        return getValue(key);
    }

    @Override
    public Observable<String> saveString(String key, String value) {
        return saveValue(key, value);
    }

    @Override
    public Observable<Boolean> getBoolean(String key) {
        return getValue(key).map(Boolean::parseBoolean);
    }

    @Override
    public Observable<Boolean> saveBoolean(String key, Boolean value) {
        return saveValue(key, value.toString()).map(Boolean::parseBoolean);
    }
}
