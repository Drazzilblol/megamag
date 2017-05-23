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
        try {
            menus.add(MenuData.builder()
                    .title(context.getString(R.string.drawer_menu_announcements))
                    .type(ItemTypeFactory.getAnnouncementsType())
                    .groupType(GroupTypeFactory.getAnnouncementGroupId())
                    .icon(R.drawable.ic_today_black_24dp)
                    .build());
            menus.add(MenuData.builder()
                    .title(context.getString(R.string.drawer_menu_tickets))
                    .type(ItemTypeFactory.getTicketType())
                    .groupType(GroupTypeFactory.getAnnouncementGroupId())
                    .icon(R.drawable.ic_local_movies_black_24dp)
                    .build());
        } catch (Exception e) {
            Timber.e(e);
        }
        return menus;
    }
}
