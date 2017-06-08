package by.instinctools.megamag.presentation.event_details.info_comments;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.domain.models.EventComment;
import by.instinctools.megamag.presentation.MvpView;

public interface EventCommentView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(@NonNull List<EventComment> eventComments);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideData();
}
