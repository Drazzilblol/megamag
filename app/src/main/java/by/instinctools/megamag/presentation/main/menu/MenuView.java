package by.instinctools.megamag.presentation.main.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.Menu;
import by.instinctools.megamag.presentation.MvpView;

public interface MenuView extends MvpView {

    void goToInfoScreen(int infoId);

    void goToAnnouncementsScreen();

    void goToTicketsScreen();

    void showMenu(@NonNull List<Menu> menuList);

    void addMenuItem(@NonNull Menu menu, int groupId);
}
