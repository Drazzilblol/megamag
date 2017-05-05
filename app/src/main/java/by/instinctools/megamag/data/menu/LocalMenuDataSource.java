package by.instinctools.megamag.data.menu;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.data.info.RemoteInfoDataSource;
import io.reactivex.Observable;

public class LocalMenuDataSource implements MenuDataSource {

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
        return Observable.just(getStubMenus());
    }

    @NonNull
    @Override
    public Observable<List<MenuData>> saveAll(List<MenuData> collection) {
        throw new UnsupportedOperationException();
    }


    private List<MenuData> getStubMenus() {
        List<MenuData> tickets = new ArrayList<>();
        tickets.add(MenuData.builder()
                .title("How To Pay")
                .menuId(RemoteInfoDataSource.HOW_PAY)
                .targetId(RemoteInfoDataSource.INFO_GROUP_ID)
                .build());
        tickets.add(MenuData.builder()
                .title("How To Book")
                .menuId(RemoteInfoDataSource.HOW_BOOK)
                .targetId(RemoteInfoDataSource.INFO_GROUP_ID)
                .build());
        tickets.add(MenuData.builder()
                .title("Rules")
                .menuId(RemoteInfoDataSource.RULES)
                .targetId(RemoteInfoDataSource.INFO_GROUP_ID)
                .build());
        return tickets;
    }
}
