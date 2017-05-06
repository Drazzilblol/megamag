package by.instinctools.megamag.data.menu.local;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.common.database.menu.MenuDbHelper;
import by.instinctools.megamag.data.menu.MenuData;
import io.reactivex.Observable;

public class LocalMenuTheaterDataSource extends LocalMenuDataSource {

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
        return Observable.just(getMenusFromDb(1002));
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> saveAll(List<MenuData> collection) {
        throw new UnsupportedOperationException();
    }
}
