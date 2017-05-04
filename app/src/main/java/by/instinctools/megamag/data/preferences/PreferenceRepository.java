package by.instinctools.megamag.data.preferences;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface PreferenceRepository extends Repository {

    @NonNull
    Observable<Integer> getStartupCounter();

    @NonNull
    Observable<Integer> setStartupCounter(int counter);
}
