package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import by.instinctools.megamag.data.menu.local.LocalMenuProfileDataSource;
import by.instinctools.megamag.data.menu.local.LocalMenuTheaterDataSource;
import by.instinctools.megamag.data.menu.remote.RemoteMenuTheaterDataSource;
import io.reactivex.Observable;

public class MenuProfileRepositoryImpl implements MenuRepository {

    @NonNull
    DataSource<String, MenuData> localDataSource = new LocalMenuProfileDataSource();

    @NonNull
    @Override
    public Observable<List<MenuData>> getMenuList() {
        return localDataSource.getAll();
    }
}
