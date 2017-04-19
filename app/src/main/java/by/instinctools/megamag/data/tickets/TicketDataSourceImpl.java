package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.data.models.Ticket;
import by.instinctools.megamag.data.models.TicketImpl;
import io.reactivex.Observable;

public class TicketDataSourceImpl implements TicketDataSource {


    @Override
    public Observable<Ticket> getValue(@NonNull String key) {
        return null;
    }

    @Override
    public Observable<Ticket> saveValue(@NonNull String key, @NonNull Ticket value) {
        return null;
    }

    @Override
    public Observable<List<Ticket>> getAll() {
        return Observable.just(getStubTickets());
    }

    @Override
    public Observable<List<Ticket>> saveAll(List<Ticket> collection) {
        return null;
    }

    private List<Ticket> getStubTickets() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new TicketImpl("3", "3", "3"));
        tickets.add(new TicketImpl("2", "2", "2"));
        tickets.add(new TicketImpl("1", "1", "1"));
        return tickets;
    }
}
