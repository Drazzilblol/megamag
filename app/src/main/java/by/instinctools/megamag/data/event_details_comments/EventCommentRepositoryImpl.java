package by.instinctools.megamag.data.event_details_comments;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class EventCommentRepositoryImpl implements EventCommentRepository {

    EventCommentDataSource dataSource = new EventCommentRemoteDataSource();

    @Override
    public Observable<List<EventCommentData>> getComments(@NonNull String eventId) {
        return dataSource.getAll(eventId);
    }
}
