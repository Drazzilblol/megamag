package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class RemoteTicketDataSource implements TicketDataSource {

    @Override
    public Observable<TicketData> getValue(@NonNull String key) {
        return null;
    }

    @Override
    public Observable<TicketData> saveValue(@NonNull String key, @NonNull TicketData value) {
        return null;
    }

    @DebugLog
    @Override
    public Observable<List<TicketData>> getAll() {
        return Observable.just(getStubTickets());
    }

    @Override
    public Observable<List<TicketData>> saveAll(List<TicketData> collection) {
        return null;
    }

    private List<TicketData> getStubTickets() {
        List<TicketData> tickets = new ArrayList<>();
        tickets.add(TicketData.create("3", "3", "3"));
        tickets.add(TicketData.create("2", "2", "2"));
        tickets.add(TicketData.create("1", "1", "1"));
        return tickets;
    }
}
