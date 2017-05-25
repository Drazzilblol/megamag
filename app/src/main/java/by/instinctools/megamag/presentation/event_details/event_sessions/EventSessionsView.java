package by.instinctools.megamag.presentation.event_details.event_sessions;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.EventSession;
import by.instinctools.megamag.presentation.MvpView;

interface EventSessionsView extends MvpView {

    void showData(@NonNull List<EventSession> eventSessions);

    void hideData();
}
