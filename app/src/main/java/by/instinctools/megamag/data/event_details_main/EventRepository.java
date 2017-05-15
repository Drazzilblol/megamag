package by.instinctools.megamag.data.event_details_main;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface EventRepository extends Repository {
    Observable<List<EventData>> getEventInfo();
}
