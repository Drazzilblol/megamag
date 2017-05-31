package by.instinctools.megamag.data.event_details_session;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class RemoteEventSessionDataSource implements EventSessionDataSource {

    @NonNull
    @Override
    public Observable<EventSessionData> getValue(@NonNull String key) {
        return null;
    }

    @NonNull
    @Override
    public Observable<EventSessionData> saveValue(@NonNull String key, @NonNull EventSessionData value) {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<EventSessionData>> getAll() {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<EventSessionData>> saveAll(List<EventSessionData> collection) {
        return null;
    }

    @Override
    public Observable<List<EventSessionData>> getAll(@NonNull String eventId) {
        return getEvent(eventId);
    }

    private Observable<List<EventSessionData>> getEvent(String id) {
        Call<ResponseBody> call = Application.getApi().getDetails(id);

        return Observable.defer(() -> Observable.just(call.execute()))
                .flatMap(Observable::just)
                .map(r -> EventSessionParser.parseSession(r.body().string()));

    }
}
