package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

class RemoteTicketDataSource extends BaseRemoteDataSource<String, TicketData> {

    @NonNull
    @DebugLog
    @Override
    public Observable<List<TicketData>> getAll() {
        return getTickets();
    }

    @NonNull
    private Observable<List<TicketData>> getTickets() {
        return Application.getApi()
                .getData()
                .map(TicketParser::parseTickets);
    }
}
