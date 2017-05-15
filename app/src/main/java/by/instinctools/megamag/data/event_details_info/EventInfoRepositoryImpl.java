package by.instinctools.megamag.data.event_details_info;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public class EventInfoRepositoryImpl implements EventInfoRepository {

    @NonNull
    private EventInfoDataSource dataSource = new RemoteEventInfoDataSource();

    @Override
    public Observable<List<EventInfoData>> getEventInfo() {
        return dataSource.getAll();
    }
}
