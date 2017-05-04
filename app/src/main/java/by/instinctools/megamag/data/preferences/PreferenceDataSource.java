package by.instinctools.megamag.data.preferences;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import by.instinctools.megamag.data.DataSource;
import io.reactivex.Observable;

interface PreferenceDataSource extends DataSource<String, String> {

    @NonNull
    Observable<Integer> getInteger(@NonNull String key);

    @NonNull
    Observable<Integer> saveInteger(@NonNull String key, @Nullable Integer value);

    @NonNull
    Observable<Float> getFloat(@NonNull String key);

    @NonNull
    Observable<Float> saveFloat(@NonNull String key, @Nullable Float value);

    @NonNull
    Observable<Long> getLong(@NonNull String key);

    @NonNull
    Observable<Long> saveLong(@NonNull String key, @Nullable Long value);

    @NonNull
    Observable<String> getString(@NonNull String key);

    @NonNull
    Observable<String> saveString(@NonNull String key, @Nullable String value);

    @NonNull
    Observable<Boolean> getBoolean(@NonNull String key);

    @NonNull
    Observable<Boolean> saveBoolean(@NonNull String key, @Nullable Boolean value);
}
