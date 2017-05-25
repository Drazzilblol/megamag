package by.instinctools.megamag.data.event_details_session;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface EventSessionRepository extends Repository {

    Observable<List<EventSessionData>> getSessions(@NonNull String eventId);
}
