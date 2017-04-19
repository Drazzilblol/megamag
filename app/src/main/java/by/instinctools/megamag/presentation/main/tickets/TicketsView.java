package by.instinctools.megamag.presentation.main.tickets;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.TicketViewModel;
import by.instinctools.megamag.presentation.MvpView;

interface TicketsView extends MvpView {

    void showData(@NonNull List<TicketViewModel> ticketsList);

    void hideData();
}
