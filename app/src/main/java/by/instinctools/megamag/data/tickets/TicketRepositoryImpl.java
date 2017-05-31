package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import io.reactivex.Observable;

public class TicketRepositoryImpl implements TicketRepository {

    @NonNull
    private DataSource<String, TicketData> ticketDataSource = new RemoteTicketDataSource();

    @NonNull
    @Override
    public Observable<List<TicketData>> getTicketList() {
        return ticketDataSource.getAll();
    }
}
