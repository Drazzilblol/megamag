package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.event_details_comments.EventCommentRepository;
import by.instinctools.megamag.data.event_details_comments.EventCommentRepositoryImpl;
import by.instinctools.megamag.data.event_details_info.EventInfoRepository;
import by.instinctools.megamag.data.event_details_info.EventInfoRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.EventCommentConverter;
import by.instinctools.megamag.domain.common.converters.EventInfoConverter;
import by.instinctools.megamag.domain.models.EventComment;
import by.instinctools.megamag.domain.models.EventInfo;
import io.reactivex.Observable;

public class GetEventCommentUseCase implements UseCase<EventComment> {

    @NonNull
    private EventCommentRepository repository = new EventCommentRepositoryImpl();

    @NonNull
    private EventCommentConverter converter = new EventCommentConverter();

    public Observable<List<EventComment>> execute(@NonNull String eventId) {
        return repository.getComments(eventId)
                .map(converter::convert);
    }

    @Override
    public Observable<EventComment> execute() {
        throw new UnsupportedOperationException();
    }
}
