package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import by.instinctools.megamag.data.menu.local.LocalMenuInfoDataSource;
import io.reactivex.Observable;

public class MenuInfoRepositoryImpl implements MenuRepository {

    @NonNull
    DataSource<String, MenuData> dataSource = new LocalMenuInfoDataSource();

    @NonNull
    @Override
    public Observable<List<MenuData>> getMenuList() {
        return dataSource.getAll();
    }
}
