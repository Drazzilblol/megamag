package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.event_details_info.EventInfoRepository;
import by.instinctools.megamag.data.event_details_info.EventInfoRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.EventInfoConverter;
import by.instinctools.megamag.domain.models.EventInfo;
import io.reactivex.Observable;

public class GetEventInfoUseCase implements UseCase<EventInfo> {

    @NonNull
    private EventInfoRepository repository = new EventInfoRepositoryImpl();

    @NonNull
    private EventInfoConverter converter = new EventInfoConverter();

    public Observable<EventInfo> execute(@NonNull String eventId) {
        return repository.getEventInfo(eventId)
                .map(converter::convert);
    }

    @Override
    public Observable<EventInfo> execute() {
        throw new UnsupportedOperationException();
    }
}
