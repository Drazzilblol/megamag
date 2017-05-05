package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.domain.models.MenuV;

public class MenuConverter extends BaseConverter<MenuData, MenuV> {

    @NonNull
    @Override
    public MenuV convert(@NonNull MenuData menuData) {
        return MenuV.builder()
                .menuId(menuData.getMenuId())
                .title(menuData.getTitle())
                .targetId(menuData.getTargetId())
                .build();
    }
}
