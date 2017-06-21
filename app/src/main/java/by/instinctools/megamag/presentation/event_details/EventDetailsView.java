package by.instinctools.megamag.presentation.event_details;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.instinctools.megamag.domain.models.Event;
import by.instinctools.megamag.presentation.MvpView;

interface EventDetailsView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(@NonNull Event event);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideData();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void initPagerFragments(@NonNull String eventId);
}
