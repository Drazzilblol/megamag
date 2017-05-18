package by.instinctools.megamag.data.menu.remote;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.R;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import by.instinctools.megamag.data.menu.MenuData;
import io.reactivex.Observable;

public class MenuTheaterRemoteDataSource extends BaseRemoteDataSource<String, MenuData> {

    @NonNull
    @Override
    public Observable<List<MenuData>> getAll() {
        return Observable.just(getStubMenus());
    }

    private List<MenuData> getStubMenus() {
        List<MenuData> menus = new ArrayList<>();
        menus.add(MenuData.builder()
                .title("Космос")
                .menuId(300)
                .targetId(1002)
                .icon(R.drawable.ic_empty_24dp)
                .build());
        menus.add(MenuData.builder()
                .title("Красная Звезда")
                .menuId(301)
                .targetId(1002)
                .icon(R.drawable.ic_empty_24dp)
                .build());
        menus.add(MenuData.builder()
                .title("Октябрь")
                .menuId(302)
                .targetId(1002)
                .icon(R.drawable.ic_empty_24dp)
                .build());
        menus.add(MenuData.builder()
                .title("Драмматический Театр")
                .menuId(303)
                .targetId(1002)
                .icon(R.drawable.ic_empty_24dp)
                .build());
        menus.add(MenuData.builder()
                .title("Театр Кукол")
                .menuId(304)
                .targetId(1002)
                .icon(R.drawable.ic_empty_24dp)
                .build());
        return menus;
    }
}
