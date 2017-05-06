package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.DataSource;
import by.instinctools.megamag.data.menu.local.LocalMenuTheaterDataSource;
import by.instinctools.megamag.data.menu.remote.RemoteMenuTheaterDataSource;
import io.reactivex.Observable;

public class MenuTheaterRepositoryImpl implements MenuRepository {

    @NonNull
    DataSource<String, MenuData> localDataSource = new LocalMenuTheaterDataSource();

    @NonNull
    DataSource<String, MenuData> remoteDataSource = new RemoteMenuTheaterDataSource();

    @NonNull
    @Override
    public Observable<List<MenuData>> getMenuList() {
        return localDataSource.getAll()
                .filter(list -> list.size() > 0)
                .switchIfEmpty(remoteDataSource.getAll()
                        .flatMap(localDataSource::saveAll));
    }
}
