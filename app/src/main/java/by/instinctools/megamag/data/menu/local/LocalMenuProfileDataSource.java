package by.instinctools.megamag.data.menu.local;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.data.menu.MenuData;
import io.reactivex.Observable;

public class LocalMenuProfileDataSource extends LocalMenuDataSource {

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

    @NonNull
    private List<MenuData> getStubMenus() {
        List<MenuData> menus = new ArrayList<>();
        Context context = Application.getAppContext();
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_bucket))
                .menuId(500)
                .targetId(1005)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_info))
                .menuId(501)
                .targetId(1005)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_history))
                .menuId(502)
                .targetId(1005)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_edit))
                .menuId(503)
                .targetId(1005)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_exit))
                .menuId(504)
                .targetId(1005)
                .build());
        return menus;
    }
}
