package by.instinctools.megamag.data.event_details_comments;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import io.reactivex.Observable;

interface EventCommentDataSource extends DataSource<String, EventCommentData> {

    Observable<List<EventCommentData>> getAll(@NonNull String eventId);
}
