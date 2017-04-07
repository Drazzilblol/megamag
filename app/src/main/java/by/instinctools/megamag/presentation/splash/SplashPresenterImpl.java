package by.instinctools.megamag.presentation.splash;

import android.os.Handler;

import by.instinctools.megamag.presentation.BasePresenter;

class SplashPresenterImpl extends BasePresenter<SplashView> implements SplashPresenter {
    private static Handler handler = new Handler();

    private Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {
            getViewReference().goToMainScreen();
        }
    };

    @Override
    public void attach(Object view) {
        super.attach(view);
        handler.postDelayed(splashRunnable, 1000);
    }
}
