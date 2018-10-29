package by.instinctools.megamag.presentation.event_details.event_info;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.instinctools.megamag.domain.models.EventInfo;
import by.instinctools.megamag.presentation.MvpView;

interface EventInfoView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(@NonNull EventInfo eventInfo);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideData();
}
