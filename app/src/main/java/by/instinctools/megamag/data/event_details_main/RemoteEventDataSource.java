package by.instinctools.megamag.data.event_details_main;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import io.reactivex.Observable;

public class RemoteEventDataSource implements EventDataSource {

    @NonNull
    @Override
    public Observable<EventData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<EventData> saveValue(@NonNull String key, @NonNull EventData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<EventData>> getAll() {
        return getEvent();
    }

    @NonNull
    @Override
    public Observable<List<EventData>> saveAll(List<EventData> collection) {
        throw new UnsupportedOperationException();
    }


    private Observable<List<EventData>> getEvent() {
        return Application.getApi()
                .getDetails("" + 3416)
                .map(EventParser::parseEvent);
    }
}
