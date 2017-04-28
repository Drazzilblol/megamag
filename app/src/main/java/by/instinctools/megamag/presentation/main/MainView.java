package by.instinctools.megamag.presentation.main;

import by.instinctools.megamag.presentation.MvpView;

interface MainView extends MvpView {

    void goToAnnouncementsScreen();

    void goToTicketsScreen();

    void goToInfoScreen(String infoId);
}
