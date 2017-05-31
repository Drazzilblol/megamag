package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class AnnouncementRepositoryImpl implements AnnouncementRepository {

    @NonNull
    private DataSource<String, AnnouncementData> dataSource = new RemoteAnnouncementDataSource();

    @NonNull
    @DebugLog
    @Override
    public Observable<List<AnnouncementData>> getAnnouncementList() {
        return dataSource.getAll();
    }
}
