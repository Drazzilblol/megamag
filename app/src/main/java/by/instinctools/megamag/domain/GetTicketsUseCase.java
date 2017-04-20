package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.tickets.TicketRepository;
import by.instinctools.megamag.data.tickets.TicketRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.TicketsListConverter;
import by.instinctools.megamag.domain.models.Ticket;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class GetTicketsUseCase implements UseCase<List<Ticket>> {

    @NonNull
    private TicketRepository ticketRepository = new TicketRepositoryImpl();

    @DebugLog
    @Override
    public Observable<List<Ticket>> execute() {
        return ticketRepository.getTicketList()
                .map(tickets -> new TicketsListConverter().convert(tickets));
    }
}
