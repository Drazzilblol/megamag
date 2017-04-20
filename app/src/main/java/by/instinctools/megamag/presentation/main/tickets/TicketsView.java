package by.instinctools.megamag.presentation.main.tickets;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.Ticket;
import by.instinctools.megamag.presentation.MvpView;

interface TicketsView extends MvpView {

    void showData(@NonNull List<Ticket> ticketsList);

    void hideData();
}
