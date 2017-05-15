package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.event_details_info.EventInfoRepository;
import by.instinctools.megamag.data.event_details_info.EventInfoRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.EventInfoConverter;
import by.instinctools.megamag.domain.models.EventInfo;
import io.reactivex.Observable;

public class GetEventInfoUseCase implements UseCase<List<EventInfo>> {

    @NonNull
    private EventInfoRepository repository = new EventInfoRepositoryImpl();

    @NonNull
    private EventInfoConverter converter = new EventInfoConverter();

    @Override
    public Observable<List<EventInfo>> execute() {
        return repository.getEventInfo()
                .map(converter::convert);
    }
}
