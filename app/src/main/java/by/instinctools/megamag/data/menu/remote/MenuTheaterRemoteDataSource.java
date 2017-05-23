package by.instinctools.megamag.data.menu.remote;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.factory.GroupTypeFactory;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.type.ItemType;
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
                .type(new ItemType(300))
                .groupType(GroupTypeFactory.getTheaterGroupId())
                .icon(R.drawable.ic_empty_24dp)
                .build());
        menus.add(MenuData.builder()
                .title("Красная Звезда")
                .type(new ItemType(301))
                .groupType(GroupTypeFactory.getTheaterGroupId())
                .icon(R.drawable.ic_empty_24dp)
                .build());
        menus.add(MenuData.builder()
                .title("Октябрь")
                .type(new ItemType(302))
                .groupType(GroupTypeFactory.getTheaterGroupId())
                .icon(R.drawable.ic_empty_24dp)
                .build());
        menus.add(MenuData.builder()
                .title("Драмматический Театр")
                .type(new ItemType(303))
                .groupType(GroupTypeFactory.getTheaterGroupId())
                .icon(R.drawable.ic_empty_24dp)
                .build());
        menus.add(MenuData.builder()
                .title("Театр Кукол")
                .type(new ItemType(304))
                .groupType(GroupTypeFactory.getTheaterGroupId())
                .icon(R.drawable.ic_empty_24dp)
                .build());
        return menus;
    }
}
