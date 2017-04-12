package by.instinctools.megamag.domain;

import io.reactivex.Observable;

public interface UseCase<T> {

    Observable<T> execute();
}
