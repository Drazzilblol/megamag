package by.instinctools.megamag.data.event_details_session;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import by.instinctools.megamag.data.event_details_comments.EventCommentData;
import io.reactivex.Observable;

interface EventSessionDataSource extends DataSource<String, EventSessionData> {

    Observable<List<EventSessionData>> getAll(@NonNull String eventId);
}
