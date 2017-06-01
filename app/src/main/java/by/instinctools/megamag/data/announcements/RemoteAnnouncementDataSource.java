package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

class RemoteAnnouncementDataSource extends BaseRemoteDataSource<String, AnnouncementData> {

    @NonNull
    @DebugLog
    @Override
    public Observable<List<AnnouncementData>> getAll() {
        return getAnnouncements();
    }

    @NonNull
    private Observable<List<AnnouncementData>> getAnnouncements() {
        return Application.getApi()
                .getData()
                .map(AnnouncementParser::parseAnnouncements);
    }
}
