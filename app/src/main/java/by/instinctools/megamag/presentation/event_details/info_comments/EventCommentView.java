package by.instinctools.megamag.presentation.event_details.info_comments;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.EventComment;
import by.instinctools.megamag.presentation.MvpView;

public interface EventCommentView extends MvpView {

    void showData(@NonNull List<EventComment> eventComments);

    void hideData();
}
