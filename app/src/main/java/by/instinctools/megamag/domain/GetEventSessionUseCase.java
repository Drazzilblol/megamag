package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.event_details_session.EventSessionRepository;
import by.instinctools.megamag.data.event_details_session.EventSessionRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.EventSessionConverter;
import by.instinctools.megamag.domain.models.EventSession;
import io.reactivex.Observable;

public class GetEventSessionUseCase implements UseCase<List<EventSession>> {

    @NonNull
    private EventSessionRepository repository = new EventSessionRepositoryImpl();

    @NonNull
    private EventSessionConverter converter = new EventSessionConverter();

    public Observable<List<EventSession>> execute(@NonNull String eventId) {
        return repository.getSessions(eventId)
                .map(converter::convert);
    }

    @Override
    public Observable<List<EventSession>> execute() {
        throw new UnsupportedOperationException();
    }
}
