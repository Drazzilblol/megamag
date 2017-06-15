package by.instinctools.megamag.presentation.event_details.event_sessions;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.domain.models.EventSession;
import by.instinctools.megamag.presentation.MvpView;

interface EventSessionsView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(@NonNull List<List<EventSession>> eventSessions);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideData();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showNoSessions();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideNoSessions();
}
