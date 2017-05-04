package by.instinctools.megamag.presentation.main.menu;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetMenuUseCase;
import by.instinctools.megamag.domain.models.MenuV;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MenuPresenterImpl extends DisposablePresenter<MenuView> implements MenuPresenter {

    private static final int EMPTY_LIST_SIZE = 0;

    @NonNull
    GetMenuUseCase menuUseCase = new GetMenuUseCase();

    @Override
    public void attach(@NonNull MenuView menuView) {
        super.attach(menuView);
        menuView.showProgress();
        addDisposable(
                menuUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .filter(infoList -> infoList.size() > EMPTY_LIST_SIZE)
                        .switchIfEmpty(Observable.error(new ErrorException(new NoDataError())))
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void onLoadSuccess(@NonNull List<MenuV> menuList) {
        if (isViewAttached()) {
            MenuView view = getView();
            view.hideProgress();
            view.hideError();
            view.showMenu(menuList);
        }
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            MenuView view = getView();
            view.hideProgress();
            // view.hideData();
            showError(throwable);
        }
    }

    @Override
    public void onMenuPressed(int id) {
        if (isViewAttached()) {
            MenuView view = getView();
            view.goToInfoScreen(id);
        }
    }
}
