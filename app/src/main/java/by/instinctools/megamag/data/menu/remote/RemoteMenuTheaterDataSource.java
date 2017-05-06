package by.instinctools.megamag.data.menu.remote;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.menu.MenuDataSource;
import io.reactivex.Observable;

public class RemoteMenuTheaterDataSource implements MenuDataSource {

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
        List<MenuData> menus = new ArrayList<>();
        menus.add(MenuData.builder()
                .title("Космос")
                .menuId(300)
                .targetId(1002)
                .build());
        menus.add(MenuData.builder()
                .title("Красная Звезда")
                .menuId(301)
                .targetId(1002)
                .build());
        menus.add(MenuData.builder()
                .title("Октябрь")
                .menuId(302)
                .targetId(1002)
                .build());
        menus.add(MenuData.builder()
                .title("Драмматический Театр")
                .menuId(303)
                .targetId(1002)
                .build());
        menus.add(MenuData.builder()
                .title("Театр Кукол")
                .menuId(304)
                .targetId(1002)
                .build());
        return menus;
    }

}
