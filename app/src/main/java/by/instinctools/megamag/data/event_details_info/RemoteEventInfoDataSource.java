package by.instinctools.megamag.data.event_details_info;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import io.reactivex.Observable;

class RemoteEventInfoDataSource implements EventInfoDataSource {
    @NonNull
    @Override
    public Observable<EventInfoData> getValue(@NonNull String key) {
        return getEventInfo(key);
    }

    @NonNull
    @Override
    public Observable<EventInfoData> saveValue(@NonNull String key, @NonNull EventInfoData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<EventInfoData>> getAll() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<EventInfoData>> saveAll(List<EventInfoData> collection) {
        throw new UnsupportedOperationException();
    }

    private Observable<EventInfoData> getEventInfo(String id) {
        return Application.getApi()
                .getDetails(id)
                .map(EventInfoParser::parseEventInfo);
    }
}
