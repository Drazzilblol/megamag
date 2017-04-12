package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.preferences.PreferencesRepository;
import by.instinctools.megamag.data.preferences.PreferencesRepositoryImpl;
import io.reactivex.Observable;

public class IncrementAndGetStartupCounterUseCase implements UseCase<Integer> {

    @NonNull
    private PreferencesRepository repository = new PreferencesRepositoryImpl();

    @Override
    public Observable<Integer> execute() {
        return repository.getStartupCounter()
                .map(counter -> ++counter)
                .flatMap(repository::setStartupCounter);
    }
}
