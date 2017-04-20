package by.instinctools.megamag.data.tickets;


import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface TicketRepository extends Repository {

    Observable<List<TicketData>> getTicketList();
}
