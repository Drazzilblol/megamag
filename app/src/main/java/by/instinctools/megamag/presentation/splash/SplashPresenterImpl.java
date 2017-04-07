package by.instinctools.megamag.presentation.splash;

import android.os.Handler;

import by.instinctools.megamag.presentation.BasePresenter;

class SplashPresenterImpl extends BasePresenter<SplashView> implements SplashPresenter {

    private static final int DELAY_MILLIS = 1000;

    private final Handler handler = new Handler();

    private Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {
            getView().goToMainScreen();
        }
    };

    @Override
    public void attach(SplashView view) {
        super.attach(view);
        handler.postDelayed(splashRunnable, DELAY_MILLIS);
    }
}
