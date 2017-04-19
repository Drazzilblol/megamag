package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.models.Ticket;
import io.reactivex.Observable;

public class TicketRepositoryImpl implements TicketRepository {

    @NonNull
    private TicketDataSource ticketDataSource = new TicketDataSourceImpl();

    @Override
    public Observable<List<Ticket>> getTicketList() {
        return ticketDataSource.getAll();
    }

}
