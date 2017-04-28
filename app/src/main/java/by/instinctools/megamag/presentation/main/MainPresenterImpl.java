package by.instinctools.megamag.presentation.main;

import android.support.annotation.NonNull;

import by.instinctools.megamag.data.info.RemoteInfoDataSource;
import by.instinctools.megamag.presentation.BasePresenter;

class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {

    @Override
    public void attach(@NonNull MainView view) {
        super.attach(view);
        view.goToTicketsScreen();
    }

    @Override
    public void onMenuPayPressed() {
        if (isViewAttached()) {
            getView().goToInfoScreen(RemoteInfoDataSource.HOW_PAY);
        }
    }

    @Override
    public void onMenuBookPressed() {
        if (isViewAttached()) {
            getView().goToInfoScreen(RemoteInfoDataSource.HOW_BOOK);
        }
    }

    @Override
    public void onMenuRulesPressed() {
        if (isViewAttached()) {
            getView().goToInfoScreen(RemoteInfoDataSource.RULES);
        }
    }
}
