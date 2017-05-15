package by.instinctools.megamag.data.event_details_info;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import by.instinctools.megamag.domain.models.EventInfo;
import io.reactivex.Observable;

public interface EventInfoRepository extends Repository {
    public Observable<List<EventInfoData>> getEventInfo();
}
