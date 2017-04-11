package by.instinctools.megamag.presentation.splash;

import android.os.Handler;
import android.support.annotation.NonNull;

import by.instinctools.megamag.presentation.BasePresenter;

class SplashPresenterImpl extends BasePresenter<SplashView> implements SplashPresenter {

    private static final long DELAY_MILLIS = 1000L;

    @NonNull
    private final Handler handler = new Handler();

    @NonNull
    private Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {
            SplashView splashView = getView();
            if (splashView != null) {
                splashView.goToMainScreen();
            }
        }
    };

    @Override
    public void attach(@NonNull SplashView view) {
        super.attach(view);
        handler.postDelayed(splashRunnable, DELAY_MILLIS);
    }

    @Override
    public void detach() {
        super.detach();
        handler.removeCallbacks(splashRunnable);
    }
}
