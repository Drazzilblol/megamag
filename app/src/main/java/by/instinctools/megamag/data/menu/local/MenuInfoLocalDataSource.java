package by.instinctools.megamag.data.menu.local;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.data.BaseLocalDataSource;
import by.instinctools.megamag.data.info.InfoDataSource;
import by.instinctools.megamag.data.menu.MenuData;
import io.reactivex.Observable;

public class MenuInfoLocalDataSource extends BaseLocalDataSource<String, MenuData> {

    @NonNull
    private static final List<MenuData> menuList = getMenus();

    @NonNull
    @Override
    public Observable<List<MenuData>> getAll() {
        return Observable.just(menuList);
    }

    private static List<MenuData> getMenus() {
        Context context = Application.getAppContext();
        List<MenuData> menus = new ArrayList<>();
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_how_to_pay))
                .menuId(InfoDataSource.HOW_PAY)
                .targetId(InfoDataSource.INFO_GROUP_ID)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_how_to_book))
                .menuId(InfoDataSource.HOW_BOOK)
                .targetId(InfoDataSource.INFO_GROUP_ID)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_rules))
                .menuId(InfoDataSource.RULES)
                .targetId(InfoDataSource.INFO_GROUP_ID)
                .build());
        return menus;
    }
}
