package by.instinctools.megamag.data.preferences;


import android.support.annotation.NonNull;

import io.reactivex.Observable;

public class PreferenceRepositoryImpl implements PreferenceRepository {

    @NonNull
    private static final String STARTUP_COUNTER = "STARTUP_COUNTER";

    @NonNull
    private PreferenceDataSource dataSource;

    public PreferenceRepositoryImpl() {
        dataSource = new LocalPreferenceDataSource();
    }

    @Override
    public Observable<Integer> getStartupCounter() {
        return dataSource.getInteger(STARTUP_COUNTER)
                .onErrorReturnItem(0);
    }

    @Override
    public Observable<Integer> setStartupCounter(int counter) {
        return dataSource.saveInteger(STARTUP_COUNTER, counter);
    }
}
