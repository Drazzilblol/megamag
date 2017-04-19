package by.instinctools.megamag.data.tickets;


import java.util.List;

import by.instinctools.megamag.data.Repository;
import by.instinctools.megamag.data.models.Ticket;
import io.reactivex.Observable;

public interface TicketRepository extends Repository {

    Observable<List<Ticket>> getTicketList();
}
