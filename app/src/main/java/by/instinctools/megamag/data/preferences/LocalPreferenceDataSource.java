package by.instinctools.megamag.data.preferences;


import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;

import by.instinctools.megamag.common.SharedPrefs;
import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

class LocalPreferenceDataSource implements PreferenceDataSource {

    private static final String DEF_VALUE = " ";
    private static final String FALSE = "false";
    private static final String TRUE = "true";

    @NonNull
    private SharedPreferences sharedPreferences;

    LocalPreferenceDataSource() {
        sharedPreferences = SharedPrefs.getInstance().getSharedPreferences();
    }

    @DebugLog
    @Override
    public Observable<String> getValue(@NonNull final String key) {
        return Observable.just(sharedPreferences)
                .map(string -> string.getString(key, DEF_VALUE));
    }

    @DebugLog
    @Override
    public Observable<String> saveValue(@NonNull final String key, @NonNull final String value) {
        return Observable.just(sharedPreferences)
                .map(SharedPreferences::edit)
                .map(editor -> editor.putString(key, value))
                .map(SharedPreferences.Editor::commit)
                .flatMap(result -> this.getValue(key));
    }

    @Override
    public Observable<List<String>> getAll() {
        return Observable.fromIterable(sharedPreferences.getAll()
                .values())
                .map(Object::toString)
                .toList()
                .toObservable();
    }

    @Override
    public Observable<List<String>> saveAll(List<String> collection) {
        throw new UnsupportedOperationException("Can't save values without keys");
    }

    @Override
    public Observable<Integer> getInteger(@NonNull String key) {
        return getValue(key)
                .map(this::parseInteger);
    }

    @Override
    public Observable<Integer> saveInteger(@NonNull String key, Integer value) {
        return saveValue(key, String.valueOf(value))
                .map(this::parseInteger);
    }

    @Override
    public Observable<Float> getFloat(@NonNull String key) {
        return getValue(key)
                .map(this::parseFloat);
    }

    @Override
    public Observable<Float> saveFloat(@NonNull String key, Float value) {
        return saveValue(key, value.toString())
                .map(this::parseFloat);
    }

    @Override
    public Observable<Long> getLong(@NonNull String key) {
        return getValue(key)
                .map(this::parseLong);
    }

    @Override
    public Observable<Long> saveLong(@NonNull String key, Long value) {
        return saveValue(key, value.toString())
                .map(this::parseLong);
    }

    @Override
    public Observable<String> getString(@NonNull String key) {
        return getValue(key);
    }

    @Override
    public Observable<String> saveString(@NonNull String key, String value) {
        return saveValue(key, value);
    }

    @Override
    public Observable<Boolean> getBoolean(@NonNull String key) {
        return getValue(key)
                .map(this::parseBoolean);
    }

    @Override
    public Observable<Boolean> saveBoolean(@NonNull String key, Boolean value) {
        return saveValue(key, value.toString())
                .map(this::parseBoolean);
    }

    private Long parseLong(@NonNull String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException ex) {
            throw new ErrorException(new NoDataError());
        }
    }

    private Integer parseInteger(@NonNull String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new ErrorException(new NoDataError());
        }
    }

    private Boolean parseBoolean(@NonNull String value) {
        if (TextUtils.equals(value, FALSE) || TextUtils.equals(value, TRUE)) {
            return Boolean.parseBoolean(value);
        } else {
            throw new ErrorException(new NoDataError());
        }
    }

    private Float parseFloat(@NonNull String value) {
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException ex) {
            throw new ErrorException(new NoDataError());
        }
    }
}
