package by.instinctools.megamag.presentation.main.tickets;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.domain.models.Ticket;
import by.instinctools.megamag.presentation.MvpView;

@StateStrategyType(AddToEndSingleStrategy.class)
interface TicketsView extends MvpView {

    void showData(@NonNull List<Ticket> ticketsList);

    void hideData();
}
