package by.instinctools.megamag.presentation.splash;

import android.os.Handler;

import by.instinctools.megamag.presentation.AbstractPresenter;

public class SplashPresenterImpl extends AbstractPresenter<SplashView> implements SplashPresenter  {
    private static Handler handler = new Handler();

    private Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {
            getView().goToMainScreen();
        }
    };

    @Override
    public void onResume() {
        handler.postDelayed(splashRunnable, 1000);
    }
}
