package by.instinctools.megamag.data.event_details_main;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import io.reactivex.Observable;

class EventRemoteDataSource implements EventDataSource {

    @NonNull
    @Override
    public Observable<EventData> getValue(@NonNull String key) {
        return getEvent(key);
    }

    @NonNull
    @Override
    public Observable<EventData> saveValue(@NonNull String key, @NonNull EventData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<EventData>> getAll() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<EventData>> saveAll(List<EventData> collection) {
        throw new UnsupportedOperationException();
    }

    private Observable<EventData> getEvent(String id) {
        return Application.getApi()
                .getDetails(id)
                .map(EventParser::parseEvent);
    }
}
