package by.instinctools.megamag.data.event_details_comments;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import io.reactivex.Observable;

public class EventCommentRemoteDataSource extends BaseRemoteDataSource<String, EventCommentData> implements EventCommentDataSource {

    @Override
    public Observable<List<EventCommentData>> getAll(@NonNull String eventId) {
        return getComments(eventId);
    }

    private Observable<List<EventCommentData>> getComments(String id) {
        return Application.getApi()
                .getDetails(1515 + "")
                .map(CommentParser::parseComments);
    }
}
