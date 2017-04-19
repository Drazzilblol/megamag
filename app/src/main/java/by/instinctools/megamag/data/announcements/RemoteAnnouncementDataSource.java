package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.data.models.Announcement;
import by.instinctools.megamag.data.models.AnnouncementImpl;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

class RemoteAnnouncementDataSource implements AnnouncementDataSource {

    @Override
    public Observable<Announcement> getValue(@NonNull String key) {
        return null;
    }

    @Override
    public Observable<Announcement> saveValue(@NonNull String key, @NonNull Announcement value) {
        return null;
    }

    @DebugLog
    @Override
    public Observable<List<Announcement>> getAll() {
        return Observable.just(getStubAnnouncements());
    }

    @Override
    public Observable<List<Announcement>> saveAll(List<Announcement> collection) {
        return null;
    }

    private List<Announcement> getStubAnnouncements() {
        List<Announcement> announcements = new ArrayList<>();
        announcements.add(AnnouncementImpl.create("1", "1"));
        announcements.add(AnnouncementImpl.create("2", "2"));
        announcements.add(AnnouncementImpl.create("3", "3"));
        return announcements;
    }
}
