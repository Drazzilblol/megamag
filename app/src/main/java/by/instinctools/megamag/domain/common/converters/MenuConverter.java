package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.domain.models.Menu;

public class MenuConverter extends BaseConverter<MenuData, Menu> {

    @NonNull
    @Override
    public Menu convert(@NonNull MenuData menuData) {
        return Menu.builder()
                .menuId(menuData.getMenuId())
                .title(menuData.getTitle())
                .targetId(menuData.getTargetId())
                .build();
    }
}
