package by.instinctools.megamag.data.event_details_info;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

public class EventInfoRepositoryImpl implements EventInfoRepository {

    @NonNull
    private EventInfoDataSource dataSource = new RemoteEventInfoDataSource();

    @Override
    public Observable<EventInfoData> getEventInfo(@NonNull String eventId) {
        return dataSource.getValue(eventId);
    }
}
