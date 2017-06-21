package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.instinctools.megamag.data.DataSource;
import by.instinctools.megamag.data.menu.local.MenuAnnouncementLocalDataSource;
import by.instinctools.megamag.data.menu.local.MenuInfoLocalDataSource;
import by.instinctools.megamag.data.menu.local.MenuTheaterLocalDataSource;
import by.instinctools.megamag.data.menu.remote.MenuTheaterRemoteDataSource;
import io.reactivex.Observable;

public class MenuCommonRepositoryImpl implements MenuRepository {

    @NonNull
    private DataSource<String, MenuData> menuAnnouncementLocalDataSource = new MenuAnnouncementLocalDataSource();

    @NonNull
    private DataSource<String, MenuData> menuInfoLocalDataSource = new MenuInfoLocalDataSource();

    @NonNull
    private DataSource<String, MenuData> theaterLocalDataSource = new MenuTheaterLocalDataSource();

    @NonNull
    private DataSource<String, MenuData> theaterRemoteDataSource = new MenuTheaterRemoteDataSource();

    @NonNull
    @Override
    public Observable<List<MenuData>> getMenuList() {
        return Observable.zip(
                addErrorHandling(menuAnnouncementLocalDataSource.getAll()),
                addErrorHandling(theaterLocalDataSource.getAll()
                        .filter(list -> list.size() > 0)
                        .switchIfEmpty(theaterRemoteDataSource.getAll()
                                .flatMap(theaterLocalDataSource::saveAll))),
                addErrorHandling(menuInfoLocalDataSource.getAll()),
                this::zipLists
        );
    }

    @NonNull
    public Observable<MenuData> getMenuInfoItem(int itemId) {
        return menuInfoLocalDataSource.getValue(String.valueOf(itemId));
    }
    
    private Observable<List<MenuData>> addErrorHandling(Observable<List<MenuData>> observable) {
        return observable
                .onErrorReturnItem(Collections.emptyList())
                .defaultIfEmpty(Collections.emptyList());
    }

    private List<MenuData> zipLists(List<MenuData> list1, List<MenuData> list2, List<MenuData> list3) {
        List<MenuData> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        list.addAll(list3);
        return list;
    }
}
