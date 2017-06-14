package by.instinctools.megamag.presentation.main.menu;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.domain.models.Menu;
import by.instinctools.megamag.presentation.MvpView;


public interface MenuView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToInfoScreen(int infoId);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToAnnouncementsScreen();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToTicketsScreen();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToAuthScreen();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showMenu(@NonNull List<Menu> menuList);
}
