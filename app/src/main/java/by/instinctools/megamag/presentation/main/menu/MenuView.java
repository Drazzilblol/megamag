package by.instinctools.megamag.presentation.main.menu;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.domain.models.Menu;
import by.instinctools.megamag.presentation.MvpView;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MenuView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToInfoScreen(int infoId);

    void goToAnnouncementsScreen();

    void goToTicketsScreen();

    void showMenu(@NonNull List<Menu> menuList);
}
