package by.instinctools.megamag.presentation.main.menu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetCommonMenuUseCase;
import by.instinctools.megamag.domain.GetProfileMenuUseCase;
import by.instinctools.megamag.domain.models.Menu;
import by.instinctools.megamag.presentation.DisposablePresenter;
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
    private static final int SETTINGS_GROUP_ID = 1004;
    private static final int PROFILE_GROUP_ID = 1005;

    private static final int SUPPORT_ID = 104;
    private static final int REGION_ID = 400;
    private static final int ABOUT_ID = 401;
    private static final int SHARE_ID = 402;
    private static final int SETTINGS_ID = 404;
    private static final int ANNOUNCEMENTS_ID = 200;

    @NonNull
    private List<Menu> menuCommonList = new ArrayList<>();

    @NonNull
    private List<Menu> menuProfileList = new ArrayList<>();

    @NonNull
    private GetCommonMenuUseCase menuUseCase = new GetCommonMenuUseCase();

    @NonNull
    private GetProfileMenuUseCase profileUseCase = new GetProfileMenuUseCase();

    @Override
    public void attach(@NonNull MenuView menuView) {
        super.attach(menuView);
        menuView.showProgress();
        loadMenuCommon();
        menuView.goToAnnouncementsScreen();
    }

    @Override
    public void detach() {
        super.detach();
        menuProfileList.clear();
        menuCommonList.clear();
    }

    @DebugLog
    @Override
    public void onMenuPressed(int id) {
        Menu menuViewModel = getMenuById(id);
        if (isViewAttached() && menuViewModel != null) {
            MenuView view = getView();
            if (menuViewModel.getTargetId() == INFO_GROUP_ID && menuViewModel.getMenuId() != SUPPORT_ID) {
                view.goToInfoScreen(id);
            }
            if (menuViewModel.getTargetId() == ANNOUNCEMENT_GROUP_ID) {
                if (menuViewModel.getMenuId() == ANNOUNCEMENTS_ID) {
                    view.goToAnnouncementsScreen();
                } else {
                    view.goToTicketsScreen();
                }
            }
            if (menuViewModel.getTargetId() == THEATER_GROUP_ID) {
                Timber.i("Theater group");
            }
            if (menuViewModel.getTargetId() == PROFILE_GROUP_ID) {
                Timber.i("Profile group");
            }
        }
    }

    @Nullable
    private Menu getMenuById(int id) {
        Menu menuViewModel = null;
        for (Menu menu : menuCommonList) {
            if (menu.getMenuId() == id) {
                menuViewModel = menu;
            }
        }
        for (Menu menu : menuProfileList) {
            if (menu.getMenuId() == id) {
                menuViewModel = menu;
            }
        }
        return menuViewModel;
    }

    @Override
    public void onProfilePressed(boolean isSelected) {
        MenuView view = getView();
        if (isSelected) {
            if (menuCommonList.isEmpty()) {
                loadMenuCommon();
            } else {
                view.showMenu(menuCommonList);
            }
        } else {
            if (menuProfileList.isEmpty()) {
                loadMenuProfile();
            } else {
                view.showMenu(menuProfileList);
            }
        }
    }

    @DebugLog
    private void loadMenuProfile() {
        addDisposable(
                profileUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .filter(infoList -> infoList.size() > EMPTY_LIST_SIZE)
                        .switchIfEmpty(Observable.error(new ErrorException(new NoDataError())))
                        .subscribe(
                                this::onProfileLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void loadMenuCommon() {
        addDisposable(
                menuUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .filter(infoList -> infoList.size() > EMPTY_LIST_SIZE)
                        .switchIfEmpty(Observable.error(new ErrorException(new NoDataError())))
                        .map(this::createMenu)
                        .subscribe(
                                this::onCommonLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void onCommonLoadSuccess(@NonNull List<Menu> menuList) {
        if (isViewAttached()) {
            MenuView view = getView();
            view.hideProgress();
            view.hideError();
            menuCommonList.addAll(menuList);
            view.showMenu(menuCommonList);
        }
    }

    @DebugLog
    private void onProfileLoadSuccess(@NonNull List<Menu> menuList) {
        if (isViewAttached()) {
            MenuView view = getView();
            view.hideProgress();
            view.hideError();
            menuProfileList.addAll(menuList);
            view.showMenu(menuProfileList);
        }
    }

    @NonNull
    private List<Menu> createMenu(List<Menu> menuList) {
        List<Menu> menus = new ArrayList<>();
        for (Menu menu : menuList) {
            if (!menus.isEmpty() &&
                    menus.get(menus.size() - 1).getTargetId() == THEATER_GROUP_ID &&
                    menu.getTargetId() == INFO_GROUP_ID) {
                addSettingsMenuGroup(menus);
            }
            menus.add(Menu.builder()
                    .title(menu.getTitle())
                    .menuId(menu.getMenuId())
                    .targetId(menu.getTargetId())
                    .icon(menu.getIcon())
                    .build());
        }

        if (menus.get(menus.size() - 1).getTargetId() == INFO_GROUP_ID) {
            addSupportMenuItem(menus);
        }

        return menus;
    }

    private void addSupportMenuItem(List<Menu> menu) {
        Context context = Application.getAppContext();
        menu.add(menu.size(), Menu.builder()
                .title(context.getString(R.string.drawer_menu_support))
                .menuId(SUPPORT_ID)
                .targetId(INFO_GROUP_ID)
                .icon(R.drawable.ic_person_black_24dp)
                .build());
    }

    private void addSettingsMenuGroup(List<Menu> menu) {
        Context context = Application.getAppContext();
        menu.add(Menu.builder()
                .title(context.getString(R.string.drawer_menu_region))
                .menuId(REGION_ID)
                .targetId(SETTINGS_GROUP_ID)
                .icon(R.drawable.ic_add_location_black_24dp)
                .build());
        menu.add(Menu.builder()
                .title(context.getString(R.string.drawer_menu_about))
                .menuId(ABOUT_ID)
                .targetId(SETTINGS_GROUP_ID)
                .icon(R.drawable.ic_info_black_24dp)
                .build());
        menu.add(Menu.builder()
                .title(context.getString(R.string.drawer_menu_share))
                .menuId(SHARE_ID)
                .targetId(SETTINGS_GROUP_ID)
                .icon(R.drawable.ic_share_black_24dp)
                .build());
        menu.add(Menu.builder()
                .title(context.getString(R.string.drawer_menu_settings))
                .menuId(SETTINGS_ID)
                .targetId(SETTINGS_GROUP_ID)
                .icon(R.drawable.ic_settings_applications_black_24dp)
                .build());
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            MenuView view = getView();
            view.hideProgress();
            showError(throwable);
        }
    }

}
