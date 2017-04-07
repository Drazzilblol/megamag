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
        splashPresenter.attach(this);
    }

    @Override
    public void goToMainScreen() {
        Navigator.goToTicketsScreen(this);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        splashPresenter.detach();
        super.onDestroy();
    }


    @Override
    public void showError(Error error) {

    }

    @Override
    public void showProgress(boolean show) {

    }
}
