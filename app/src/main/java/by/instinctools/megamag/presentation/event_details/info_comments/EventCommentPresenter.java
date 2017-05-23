package by.instinctools.megamag.presentation.event_details.info_comments;

import by.instinctools.megamag.presentation.DisposablePresenter;

public abstract class EventCommentPresenter extends DisposablePresenter<EventCommentView> {

    abstract void setInitialValue(String eventId);
}
