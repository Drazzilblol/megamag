package by.instinctools.megamag.data.preferences;


import android.support.annotation.NonNull;

import io.reactivex.Observable;

public class PreferencesRepositoryImpl implements PreferencesRepository {

    @NonNull
    private static final String STARTUP_COUNTER = "STARTUP_COUNTER";

    @NonNull
    private PreferencesDataSource dataSource;

    public PreferencesRepositoryImpl() {
        dataSource = new LocalPreferencesDataSource();
    }

    @Override
    public Observable<Integer> getStartupCounter() {
        return dataSource.getInteger(STARTUP_COUNTER);
    }

    @Override
    public Observable<Integer> setStartupCounter(int counter) {
        return dataSource.saveInteger(STARTUP_COUNTER, counter);
    }
}
