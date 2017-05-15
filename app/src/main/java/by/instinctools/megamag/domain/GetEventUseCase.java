package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.event_details_info.EventInfoRepository;
import by.instinctools.megamag.data.event_details_info.EventInfoRepositoryImpl;
import by.instinctools.megamag.data.event_details_main.EventRepository;
import by.instinctools.megamag.data.event_details_main.EventRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.EventConverter;
import by.instinctools.megamag.domain.common.converters.EventInfoConverter;
import by.instinctools.megamag.domain.models.Event;
import io.reactivex.Observable;

public class GetEventUseCase implements UseCase<Event> {

    @NonNull
    private EventRepository repository = new EventRepositoryImpl();

    @NonNull
    private EventConverter converter = new EventConverter();

    @Override
    public Observable<Event> execute() {
        return repository.getEventInfo()
                .map(eventDatas -> eventDatas.get(0))
                .map(converter::convert);
    }
}
