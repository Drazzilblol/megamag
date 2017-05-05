package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import io.reactivex.Observable;

public class MenuAnnouncementRepositoryImpl implements MenuRepository {

    @NonNull
    DataSource<String, MenuData> dataSource = new MenuAnnouncementDataSource();

    @NonNull
    @Override
    public Observable<List<MenuData>> getMenuList() {
        return dataSource.getAll();
    }
}
