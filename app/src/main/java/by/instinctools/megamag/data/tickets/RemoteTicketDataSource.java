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
        tickets.add(TicketData.builder()
                .title("Форсаж 8 16+ 3D Atmos")
                .beginsWith("билеты с 21/04/2017")
                .coverUrl("http://kinoteatr.megamag.by/images/categories_sec/forsazh_8_6.jpg")
                .build());
        tickets.add(TicketData.builder()
                .title("Форсаж 8 16+ 3D Atmos")
                .beginsWith("билеты с 21/04/2017")
                .coverUrl("http://kinoteatr.megamag.by/images/categories_sec/forsazh_8_6.jpg")
                .build());
        tickets.add(TicketData.builder()
                .title("Форсаж 8 16+ 3D Atmos")
                .beginsWith("билеты с 21/04/2017")
                .coverUrl("http://kinoteatr.megamag.by/images/categories_sec/forsazh_8_6.jpg")
                .build());
        return tickets;
    }
}
