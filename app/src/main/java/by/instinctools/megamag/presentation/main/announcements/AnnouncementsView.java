package by.instinctools.megamag.presentation.main.announcements;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.presentation.MvpView;


interface AnnouncementsView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(@NonNull List<Announcement> announcementList);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideData();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showToolbarTitle();
}
