package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;

class RemoteTicketDataSource extends BaseRemoteDataSource<String, TicketData> {

    @NonNull
    @DebugLog
    @Override
    public Observable<List<TicketData>> getAll() {
        return getTickets();
    }

    @NonNull
    private Observable<List<TicketData>> getTickets() {
        Call<ResponseBody> call = Application.getApi().getData();

        return Observable.defer(() -> Observable.just(call.execute()))
                .map(r -> TicketParser.parseTickets(r.body().string()));
    }
}
