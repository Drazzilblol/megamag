package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import by.instinctools.megamag.data.menu.local.MenuProfileLocalDataSource;
import io.reactivex.Observable;

public class MenuProfileRepositoryImpl implements MenuRepository {

    @NonNull
    private DataSource<String, MenuData> localDataSource = new MenuProfileLocalDataSource();

    @NonNull
    @Override
    public Observable<List<MenuData>> getMenuList() {
        return localDataSource.getAll();
    }
}
