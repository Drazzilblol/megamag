package by.instinctools.megamag.presentation.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.utils.Navigator;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashPresenter = new SplashPresenterImpl();
    }

    @Override
    protected void onStart() {
        splashPresenter.attach(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        splashPresenter.detach();
        super.onStop();
    }

    @Override
    public void goToMainScreen() {
        Navigator.goToMainScreen(this);
        finish();
    }

    @Override
    public void showError(Error error) {

    }

    @Override
    public void showProgress(boolean show) {

    }
}
