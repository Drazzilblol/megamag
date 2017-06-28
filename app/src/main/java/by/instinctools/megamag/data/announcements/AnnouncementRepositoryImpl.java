package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class AnnouncementRepositoryImpl implements AnnouncementRepository {

    @NonNull
    private RemoteAnnouncementDataSource dataSource = new RemoteAnnouncementDataSource();

    @NonNull
    @DebugLog
    @Override
    public Observable<List<AnnouncementData>> getAnnouncementList(@NonNull String pageNumber) {
        return dataSource.getAll(pageNumber);
    }
}
