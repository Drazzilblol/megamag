package by.instinctools.megamag.presentation.event_details.event_sessions;

import com.arellomobile.mvp.InjectViewState;

@InjectViewState
class EventSessionsPresenterImpl extends EventSessionsPresenter {

    private String eventId;

    @Override
    void setInitialValue(String eventId) {
        this.eventId = eventId;
    }
}
