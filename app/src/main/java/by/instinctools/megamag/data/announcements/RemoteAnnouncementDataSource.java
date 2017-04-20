package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;
import io.reactivex.Observable;

class RemoteAnnouncementDataSource implements AnnouncementDataSource {

    @Override
    public Observable<AnnouncementData> getValue(@NonNull String key) {
        return null;
    }

    @Override
    public Observable<AnnouncementData> saveValue(@NonNull String key, @NonNull AnnouncementData value) {
        return null;
    }

    @DebugLog
    @Override
    public Observable<List<AnnouncementData>> getAll() {
        return Observable.just(getStubAnnouncements());
    }

    @Override
    public Observable<List<AnnouncementData>> saveAll(List<AnnouncementData> collection) {
        return null;
    }

    private List<AnnouncementData> getStubAnnouncements() {
        List<AnnouncementData> announcements = new ArrayList<>();
        announcements.add(AnnouncementData.create("1", "1", "1"));
        announcements.add(AnnouncementData.create("2", "2", "1"));
        announcements.add(AnnouncementData.create("3", "3", "1"));
        return announcements;
    }
}
