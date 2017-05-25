package by.instinctools.megamag.data.event_details_session;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class RemoteEventSessionDataSource implements EventSessionDataSource {

    @NonNull
    @Override
    public Observable<EventSessionData> getValue(@NonNull String key) {
        return null;
    }

    @NonNull
    @Override
    public Observable<EventSessionData> saveValue(@NonNull String key, @NonNull EventSessionData value) {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<EventSessionData>> getAll() {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<EventSessionData>> saveAll(List<EventSessionData> collection) {
        return null;
    }

    @Override
    public Observable<List<EventSessionData>> getAll(@NonNull String eventId) {
        return null;
    }
}
