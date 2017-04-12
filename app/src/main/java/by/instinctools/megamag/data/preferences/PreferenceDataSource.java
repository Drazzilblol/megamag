package by.instinctools.megamag.data.preferences;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import by.instinctools.megamag.data.DataSource;
import io.reactivex.Observable;

interface PreferenceDataSource extends DataSource<String, String> {

    Observable<Integer> getInteger(@NonNull String key);

    Observable<Integer> saveInteger(@NonNull String key, @Nullable Integer value);

    Observable<Float> getFloat(@NonNull String key);

    Observable<Float> saveFloat(@NonNull String key, @Nullable Float value);

    Observable<Long> getLong(@NonNull String key);

    Observable<Long> saveLong(@NonNull String key, @Nullable Long value);

    Observable<String> getString(@NonNull String key);

    Observable<String> saveString(@NonNull String key, @Nullable String value);

    Observable<Boolean> getBoolean(@NonNull String key);

    Observable<Boolean> saveBoolean(@NonNull String key, @Nullable Boolean value);

}
