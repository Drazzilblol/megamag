package by.instinctools.megamag.presentation.main.menu;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetMenuUseCase;
import by.instinctools.megamag.domain.models.MenuV;
import by.instinctools.megamag.presentation.DisposablePresenter;
import by.instinctools.megamag.presentation.main.menu.models.MenuViewModel;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MenuPresenterImpl extends DisposablePresenter<MenuView> implements MenuPresenter {

    private static final int EMPTY_LIST_SIZE = 0;

    private static final int INFO_GROUP_ID = 1000;
    private static final int ANNOUNCEMENT_GROUP_ID = 1001;
    private static final int THEATER_GROUP_ID = 1002;

    @NonNull
    private List<MenuViewModel> menuList = new ArrayList<>();

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
                        .map(this::buildMenu)
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void onLoadSuccess(@NonNull List<MenuViewModel> menuList) {
        if (isViewAttached()) {
            MenuView view = getView();
            view.hideProgress();
            view.hideError();
            this.menuList.addAll(menuList);
            view.showMenu(menuList);
        }
    }

    private List<MenuViewModel> buildMenu(List<MenuV> menuList) {
        List<MenuViewModel> menuViewModels = new ArrayList<>();
        for (MenuV menu : menuList) {
            menuViewModels.add(MenuViewModel.builder()
                    .title(menu.getTitle())
                    .menuId(menu.getMenuId())
                    .targetId(menu.getTargetId())
                    .build());
        }
        return menuViewModels;
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
        MenuViewModel menuViewModel = getMenuById(id);
        if (isViewAttached() && menuViewModel != null) {
            MenuView view = getView();
            if (menuViewModel.getTargetId() == INFO_GROUP_ID) {
                view.goToInfoScreen(id);
            }
            if (menuViewModel.getTargetId() == ANNOUNCEMENT_GROUP_ID) {
                Timber.i("Announcement group");
            }
            if (menuViewModel.getTargetId() == THEATER_GROUP_ID) {
                Timber.i("Theater group");
            }
        }
    }

    @Nullable
    private MenuViewModel getMenuById(int id) {
        MenuViewModel menuViewModel = null;
        for (MenuViewModel menu : menuList) {
            if (menu.getMenuId() == id) {
                menuViewModel = menu;
            }
        }
        return menuViewModel;
    }
}
