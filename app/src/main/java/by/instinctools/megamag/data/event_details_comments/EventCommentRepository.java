package by.instinctools.megamag.data.event_details_comments;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface EventCommentRepository extends Repository {

    Observable<List<EventCommentData>> getComments(@NonNull String eventId);
}
