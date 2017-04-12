package by.instinctools.megamag.presentation.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.utils.Navigator;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenter splashPresenter;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar) findViewById(R.id.activity_splash_progress_bar);
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
    public void goToProfileScreen() {
        Navigator.goToProfileScreen(this);
        finish();
    }

    @Override
    public void showError(@NonNull Error error) {
        Toast.makeText(
                this,
                error.getErrorMessage(),
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
