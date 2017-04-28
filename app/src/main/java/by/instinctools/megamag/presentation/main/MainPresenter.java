package by.instinctools.megamag.presentation.main;

import by.instinctools.megamag.presentation.MvpPresenter;

interface MainPresenter extends MvpPresenter<MainView> {

    void onMenuPayPressed();

    void onMenuBookPressed();

    void onMenuRulesPressed();
}
