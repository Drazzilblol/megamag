package by.instinctools.megamag.data.menu.local;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.factory.GroupTypeFactory;
import by.instinctools.megamag.common.factory.ItemTypeFactory;
import by.instinctools.megamag.data.BaseLocalDataSource;
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
                .type(ItemTypeFactory.getHowPayType())
                .groupType(GroupTypeFactory.getInfoGroupType())
                .icon(R.drawable.ic_payment_black_24dp)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_how_to_book))
                .type(ItemTypeFactory.getHowBookType())
                .groupType(GroupTypeFactory.getInfoGroupType())
                .icon(R.drawable.ic_add_shopping_cart_black_24dp)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_rules))
                .type(ItemTypeFactory.getRulesType())
                .groupType(GroupTypeFactory.getInfoGroupType())
                .icon(R.drawable.ic_announcement_black_24dp)
                .build());
        return menus;
    }
}
