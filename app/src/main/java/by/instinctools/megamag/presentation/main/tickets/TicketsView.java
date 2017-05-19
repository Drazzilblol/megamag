package by.instinctools.megamag.presentation.main.tickets;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.domain.models.Ticket;
import by.instinctools.megamag.presentation.MvpView;


interface TicketsView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(@NonNull List<Ticket> ticketsList);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideData();

    void goToDetailsScreen(String detailsId);
}
