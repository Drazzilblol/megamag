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
import by.instinctools.megamag.common.factory.GroupTypeFactory;
import by.instinctools.megamag.common.factory.ItemTypeFactory;
import by.instinctools.megamag.data.type.Type;
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
        Menu menu = getMenuById(id);
        if (isViewAttached() && menu != null) {
            Type menuType = menu.getType();
            Type menuGroupType = menu.getGroupType();
            MenuView view = getView();
            if (menuGroupType.equals(GroupTypeFactory.getInfoGroupType()) && !menuType.equals(ItemTypeFactory.getSupportType())) {
                view.goToInfoScreen(id);
            }
            if (menuGroupType.equals(GroupTypeFactory.getAnnouncementGroupType())) {
                if (menuType.equals(ItemTypeFactory.getAnnouncementsType())) {
                    view.goToAnnouncementsScreen();
                } else {
                    view.goToTicketsScreen();
                }
            }
            if (menuGroupType.equals(GroupTypeFactory.getTheaterGroupType())) {
                Timber.i("Theater group");
            }
            if (menuGroupType.equals(GroupTypeFactory.getProfileGroupType())) {
                Timber.i("Profile group");
            }
        }
    }

    @Nullable
    private Menu getMenuById(int id) {
        Menu menuModel = null;
        for (Menu menu : menuCommonList) {
            if (menu.getType().getId() == id) {
                menuModel = menu;
            }
        }
        for (Menu menu : menuProfileList) {
            if (menu.getType().getId() == id) {
                menuModel = menu;
            }
        }
        return menuModel;
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
                    (menus.get(menus.size() - 1).getGroupType().equals(GroupTypeFactory.getTheaterGroupType()) ||
                            menus.get(menus.size() - 1).getGroupType().equals(GroupTypeFactory.getAnnouncementGroupType())) &&
                    menu.getGroupType().equals(GroupTypeFactory.getInfoGroupType())) {
                addSettingsMenuGroup(menus);
            }
            menus.add(Menu.builder()
                    .title(menu.getTitle())
                    .type(menu.getType())
                    .groupType(menu.getGroupType())
                    .icon(menu.getIcon())
                    .build());
        }

        if (menus.get(menus.size() - 1).getGroupType().equals(GroupTypeFactory.getInfoGroupType())) {
            addSupportMenuItem(menus);
        }

        return menus;
    }

    private void addSupportMenuItem(List<Menu> menu) {
        Context context = Application.getAppContext();
        menu.add(menu.size(), Menu.builder()
                .title(context.getString(R.string.drawer_menu_support))
                .type(ItemTypeFactory.getSupportType())
                .groupType(GroupTypeFactory.getInfoGroupType())
                .icon(R.drawable.ic_person_black_24dp)
                .build());
    }

    private void addSettingsMenuGroup(List<Menu> menu) {
        Context context = Application.getAppContext();
        menu.add(Menu.builder()
                .title(context.getString(R.string.drawer_menu_region))
                .type(ItemTypeFactory.getRegionType())
                .groupType(GroupTypeFactory.getSettingsGroupType())
                .icon(R.drawable.ic_add_location_black_24dp)
                .build());
        menu.add(Menu.builder()
                .title(context.getString(R.string.drawer_menu_about))
                .type(ItemTypeFactory.getAboutType())
                .groupType(GroupTypeFactory.getSettingsGroupType())
                .icon(R.drawable.ic_info_black_24dp)
                .build());
        menu.add(Menu.builder()
                .title(context.getString(R.string.drawer_menu_share))
                .type(ItemTypeFactory.getShareType())
                .groupType(GroupTypeFactory.getSettingsGroupType())
                .icon(R.drawable.ic_share_black_24dp)
                .build());
        menu.add(Menu.builder()
                .title(context.getString(R.string.drawer_menu_settings))
                .type(ItemTypeFactory.getSettingsType())
                .groupType(GroupTypeFactory.getSettingsGroupType())
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
