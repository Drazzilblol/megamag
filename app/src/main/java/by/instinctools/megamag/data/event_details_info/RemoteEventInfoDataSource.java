package by.instinctools.megamag.data.event_details_info;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class RemoteEventInfoDataSource implements EventInfoDataSource {
    @NonNull
    @Override
    public Observable<EventInfoData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<EventInfoData> saveValue(@NonNull String key, @NonNull EventInfoData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<EventInfoData>> getAll() {
        return null;
    }

    @NonNull
    @Override
    public Observable<List<EventInfoData>> saveAll(List<EventInfoData> collection) {
        throw new UnsupportedOperationException();
    }
}
