package by.instinctools.megamag.data.event_details_main;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

public class EventRepositoryImpl implements EventRepository {

    @NonNull
    private EventDataSource dataSource = new EventRemoteDataSource();

    @Override
    public Observable<EventData> getEvent(String id) {
        return dataSource.getValue(id);
    }
}
