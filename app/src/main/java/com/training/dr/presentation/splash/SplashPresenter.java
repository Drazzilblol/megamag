package com.training.dr.presentation.splash;

import android.os.Handler;

public class SplashPresenter {
    private SplashView splashView;
    private static Handler handler = new Handler();

    SplashPresenter(SplashView splashView) {
        this.splashView = splashView;
    }

    void onResume() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                splashView.goToMainScreen();
            }
        };
        handler.postDelayed(r, 1000);
    }

    void onDestroy() {
        splashView = null;
    }
}
