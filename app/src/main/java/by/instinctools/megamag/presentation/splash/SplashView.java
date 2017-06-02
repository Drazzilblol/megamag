package by.instinctools.megamag.presentation.splash;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.instinctools.megamag.presentation.MvpView;

interface SplashView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMainScreen();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToProfileScreen();

}
