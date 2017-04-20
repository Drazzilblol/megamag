package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.models.Announcement;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class AnnouncementRepositoryImpl implements AnnouncementRepository {

    @NonNull
    private AnnouncementDataSource dataSource;

    public AnnouncementRepositoryImpl() {
        dataSource = new RemoteAnnouncementDataSource();
    }

    @DebugLog
    @Override
    public Observable<List<Announcement>> getAnnouncementList() {
        return dataSource.getAll();
    }
}
