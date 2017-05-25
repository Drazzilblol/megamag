package by.instinctools.megamag.presentation.event_details.event_sessions;

import by.instinctools.megamag.presentation.DisposablePresenter;
import by.instinctools.megamag.presentation.event_details.info_comments.EventCommentView;

abstract class EventSessionsPresenter extends DisposablePresenter<EventCommentView> {

    abstract void setInitialValue(String eventId);
}
