package by.instinctools.megamag.data.menu.local;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.announcements.AnnouncementDataSource;
import by.instinctools.megamag.data.menu.MenuData;
import io.reactivex.Observable;

public class LocalMenuAnnouncementDataSource extends LocalMenuDataSource {

    @NonNull
    @Override
    public Observable<MenuData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<MenuData> saveValue(@NonNull String key, @NonNull MenuData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> getAll() {
        return Observable.just(getMenusFromDb(AnnouncementDataSource.ANNOUNCEMENT_GROUP_ID));
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> saveAll(List<MenuData> collection) {
        throw new UnsupportedOperationException();
    }
}
