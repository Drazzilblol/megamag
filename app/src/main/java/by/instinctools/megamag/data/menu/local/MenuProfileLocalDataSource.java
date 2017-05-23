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
import timber.log.Timber;

public class MenuProfileLocalDataSource extends BaseLocalDataSource<String, MenuData> {

    @NonNull
    private static final List<MenuData> menuList = getMenus();

    @NonNull
    @Override
    public Observable<List<MenuData>> getAll() {
        return Observable.just(menuList);
    }

    @NonNull
    private static List<MenuData> getMenus() {
        List<MenuData> menus = new ArrayList<>();
        Context context = Application.getAppContext();
        try {
            menus.add(MenuData.builder()
                    .title(context.getString(R.string.drawer_menu_basket))
                    .type(ItemTypeFactory.getBasketType())
                    .groupType(GroupTypeFactory.getProfileGroupId())
                    .icon(R.drawable.ic_shopping_cart_black_24dp)
                    .build());
            menus.add(MenuData.builder()
                    .title(context.getString(R.string.drawer_menu_info))
                    .type(ItemTypeFactory.getInfoType())
                    .groupType(GroupTypeFactory.getProfileGroupId())
                    .icon(R.drawable.ic_info_black_24dp)
                    .build());
            menus.add(MenuData.builder()
                    .title(context.getString(R.string.drawer_menu_history))
                    .type(ItemTypeFactory.getHistoryType())
                    .groupType(GroupTypeFactory.getProfileGroupId())
                    .icon(R.drawable.ic_history_black_24dp)
                    .build());
            menus.add(MenuData.builder()
                    .title(context.getString(R.string.drawer_menu_edit))
                    .type(ItemTypeFactory.getEditType())
                    .groupType(GroupTypeFactory.getProfileGroupId())
                    .icon(R.drawable.ic_edit_black_24dp)
                    .build());
            menus.add(MenuData.builder()
                    .title(context.getString(R.string.drawer_menu_exit))
                    .type(ItemTypeFactory.getExitType())
                    .groupType(GroupTypeFactory.getProfileGroupId())
                    .icon(R.drawable.ic_exit_to_app_black_24dp)
                    .build());
        } catch (Exception e) {
            Timber.e(e);
        }
        return menus;
    }
}
