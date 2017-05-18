package by.instinctools.megamag.presentation.main;

import android.support.annotation.NonNull;

import by.instinctools.megamag.presentation.DisposablePresenter;

class MainPresenterImpl extends DisposablePresenter<MainView> implements MainPresenter {

    @Override
    public void attach(@NonNull MainView view) {
        super.attach(view);
        view.goToAnnouncementsScreen();
    }
}
