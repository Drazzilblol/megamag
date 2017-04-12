package by.instinctools.megamag.data.preferences;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface PreferencesRepository extends Repository {

    Observable<Integer> getStartupCounter();

    Observable<Integer> setStartupCounter(int counter);

}
