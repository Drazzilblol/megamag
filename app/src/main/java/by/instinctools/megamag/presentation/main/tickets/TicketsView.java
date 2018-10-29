package by.instinctools.megamag.presentation.main.tickets;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.domain.models.Ticket;
import by.instinctools.megamag.presentation.MvpView;


interface TicketsView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(@NonNull List<Ticket> ticketsList);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideData();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToDetailsScreen(String detailsId);
}
