package by.instinctools.megamag.data.event_details_info;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.Repository;
import io.reactivex.Observable;

public interface EventInfoRepository extends Repository {
    Observable<EventInfoData> getEventInfo(@NonNull String eventId);
}
