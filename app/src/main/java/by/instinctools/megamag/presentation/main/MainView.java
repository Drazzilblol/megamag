package by.instinctools.megamag.presentation.main;

import android.support.annotation.NonNull;

import by.instinctools.megamag.presentation.MvpView;

interface MainView extends MvpView {

    void goToAnnouncementsScreen();

    void goToTicketsScreen();
}
