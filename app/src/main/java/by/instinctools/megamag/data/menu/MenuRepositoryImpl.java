package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import io.reactivex.Observable;

public class MenuRepositoryImpl implements MenuRepository {

    @NonNull
    DataSource<String, MenuData> dataSource = new LocalMenuDataSource();

    @NonNull
    @Override
    public Observable<List<MenuData>> getMenuList() {
        return dataSource.getAll();
    }
}
