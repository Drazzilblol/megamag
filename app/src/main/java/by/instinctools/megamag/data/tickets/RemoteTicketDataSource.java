package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class RemoteTicketDataSource implements TicketDataSource {

    @NonNull
    @Override
    public Observable<TicketData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<TicketData> saveValue(@NonNull String key, @NonNull TicketData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @DebugLog
    @Override
    public Observable<List<TicketData>> getAll() {
        return getTickets();
    }

    @NonNull
    @Override
    public Observable<List<TicketData>> saveAll(List<TicketData> collection) {
        throw new UnsupportedOperationException();
    }

    private Observable<List<TicketData>> getTickets() {

        Call<ResponseBody> call = Application.getApi().getData();

        return Observable.defer(() -> Observable.just(call.execute()))
                .flatMap(Observable::just)
                .map(r -> TicketParser.parseTickets(r.body().string()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
