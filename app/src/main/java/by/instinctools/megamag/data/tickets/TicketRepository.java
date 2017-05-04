package by.instinctools.megamag.data.tickets;


import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface TicketRepository extends Repository {

    @NonNull
    Observable<List<TicketData>> getTicketList();
}
