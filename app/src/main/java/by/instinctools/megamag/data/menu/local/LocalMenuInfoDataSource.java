package by.instinctools.megamag.data.menu.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.common.database.menu.MenuContract;
import by.instinctools.megamag.common.database.menu.MenuDbHelper;
import by.instinctools.megamag.data.announcements.AnnouncementDataSource;
import by.instinctools.megamag.data.info.InfoDataSource;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.menu.MenuDataSource;
import io.reactivex.Observable;

public class LocalMenuInfoDataSource extends LocalMenuDataSource {

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
        return Observable.just(getMenusFromDb(InfoDataSource.INFO_GROUP_ID));
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> saveAll(List<MenuData> collection) {
        throw new UnsupportedOperationException();
    }
}
