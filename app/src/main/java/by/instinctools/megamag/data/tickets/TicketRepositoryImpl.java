package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class TicketRepositoryImpl implements TicketRepository {

    @NonNull
    private TicketDataSource ticketDataSource = new RemoteTicketDataSource();

    @Override
    public Observable<List<TicketData>> getTicketList() {
        return ticketDataSource.getAll();
    }

}
