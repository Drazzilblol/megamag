package by.instinctools.megamag.presentation.main;

import android.support.annotation.NonNull;

import by.instinctools.megamag.presentation.BasePresenter;

class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {
    private static final int FRAGMENT_ID = 0;

    @Override
    public void attach(@NonNull MainView view) {
        super.attach(view);
        getView().addFragment(FRAGMENT_ID);
    }
}
