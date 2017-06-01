package by.instinctools.megamag.presentation.splash;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.instinctools.megamag.presentation.MvpView;

@StateStrategyType(AddToEndSingleStrategy.class)
interface SplashView extends MvpView {

    void goToMainScreen();

    void goToProfileScreen();

}
