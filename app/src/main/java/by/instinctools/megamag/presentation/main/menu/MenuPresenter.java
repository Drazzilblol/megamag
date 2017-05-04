package by.instinctools.megamag.presentation.main.menu;

import by.instinctools.megamag.presentation.MvpPresenter;

public interface MenuPresenter extends MvpPresenter<MenuView> {

    void onMenuPressed(int id);
}
