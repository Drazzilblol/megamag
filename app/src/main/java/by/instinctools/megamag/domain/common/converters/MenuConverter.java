package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.domain.models.MenuDomain;

public class MenuConverter extends BaseConverter<MenuData, MenuDomain> {

    @NonNull
    @Override
    public MenuDomain convert(@NonNull MenuData menuData) {
        return MenuDomain.builder()
                .menuId(menuData.getMenuId())
                .title(menuData.getTitle())
                .targetId(menuData.getTargetId())
                .build();
    }
}
