package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.event_details_main.EventRepository;
import by.instinctools.megamag.data.event_details_main.EventRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.EventConverter;
import by.instinctools.megamag.domain.models.Event;
import io.reactivex.Observable;

public class GetEventUseCase implements UseCase<Event> {

    @NonNull
    private EventRepository repository = new EventRepositoryImpl();

    @NonNull
    private EventConverter converter = new EventConverter();

    @Override
    public Observable<Event> execute() {
        throw new UnsupportedOperationException();
    }

    public Observable<Event> execute(String id) {
        return repository.getEvent(id)
                .map(converter::convert);
    }
}
