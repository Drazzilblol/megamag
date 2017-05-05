package by.instinctools.megamag.presentation.main.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.MenuV;
import by.instinctools.megamag.presentation.MvpView;
import by.instinctools.megamag.presentation.main.menu.models.MenuViewModel;

public interface MenuView extends MvpView {

    void goToInfoScreen(int infoId);

    void goToAnnouncementsScreen();

    void goToTicketsScreen();

    void showMenu(@NonNull List<MenuViewModel> menuList);

    void addMenuItem(@NonNull MenuV menu, int groupId);
}
