package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.preferences.PreferenceRepository;
import by.instinctools.megamag.data.preferences.PreferenceRepositoryImpl;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class IncrementAndGetStartupCounterUseCase implements UseCase<Integer> {

    @NonNull
    private PreferenceRepository repository = new PreferenceRepositoryImpl();

    @DebugLog
    @Override
    public Observable<Integer> execute() {
        return repository.getStartupCounter()
                .map(counter -> ++counter)
                .flatMap(repository::setStartupCounter);
    }
}
