package by.instinctools.megamag.presentation.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import by.instinctools.megamag.presentation.utils.Navigator;

public class SplashActivity extends AppCompatActivity implements SplashView {
    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashPresenter = new SplashPresenter(this);
    }

    @Override
    public void goToMainScreen() {
        Navigator.goToTicketsScreen(this);
        finish();
    }

    @Override
    protected void onResume() {
        splashPresenter.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        splashPresenter.onDestroy();
        super.onDestroy();
    }
}
