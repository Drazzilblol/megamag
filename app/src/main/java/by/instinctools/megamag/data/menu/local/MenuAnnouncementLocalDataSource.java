package by.instinctools.megamag.data.menu.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.data.BaseLocalDataSource;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.type.factory.GroupTypeFactory;
import by.instinctools.megamag.data.type.factory.ItemTypeFactory;
import io.reactivex.Observable;

public class MenuAnnouncementLocalDataSource extends BaseLocalDataSource<String, MenuData> {

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
                .title(context.getString(R.string.drawer_menu_announcements))
                .type(ItemTypeFactory.getAnnouncementsType())
                .groupType(GroupTypeFactory.getAnnouncementGroupType())
                .icon(R.drawable.ic_today_black_24dp)
                .build());
        menus.add(MenuData.builder()
                .title(context.getString(R.string.drawer_menu_tickets))
                .type(ItemTypeFactory.getTicketType())
                .groupType(GroupTypeFactory.getAnnouncementGroupType())
                .icon(R.drawable.ic_local_movies_black_24dp)
                .build());
        return menus;
    }

    @NonNull
    @Override
    public Observable<MenuData> getValue(@NonNull String key) {
        return Observable.just(menuList)
                .map(list -> getMenuItemById(list, key));
    }

    @Nullable
    private MenuData getMenuItemById(@NonNull List<MenuData> list, @NonNull String itemId) {
        for (MenuData menu : list) {
            String menuItemId = String.valueOf(menu.getType().getId());
            boolean isIdEquals = TextUtils.equals(menuItemId, itemId);
            if (isIdEquals) {
                return menu;
            }
        }
        return null;
    }
}
