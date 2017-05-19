package by.instinctools.megamag.data.event_details_comments;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class EventCommentRemoteDataSource implements EventCommentDataSource {
    @NonNull
    @Override
    public Observable<EventCommentData> getValue(@NonNull String key) {
        return null;
    }

    @NonNull
    @Override
    public Observable<EventCommentData> saveValue(@NonNull String key, @NonNull EventCommentData value) {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<EventCommentData>> getAll() {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<EventCommentData>> saveAll(List<EventCommentData> collection) {
        return null;
    }

    @Override
    public Observable<List<EventCommentData>> getAll(@NonNull String eventId) {
        return null;
    }
}
