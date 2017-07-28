package by.instinctools.megamag.data.event_details_session;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class EventSessionRepositoryImpl implements EventSessionRepository {

    @NonNull
    private EventSessionDataSource dataSource = new RemoteEventSessionDataSource();

    @Override
    public Observable<List<EventSessionData>> getSessions(@NonNull String eventId) {
        return dataSource.getAll(eventId);
    }
}
