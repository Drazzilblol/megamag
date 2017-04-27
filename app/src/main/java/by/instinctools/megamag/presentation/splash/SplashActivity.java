package by.instinctools.megamag.presentation.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.utils.Navigator;
import hugo.weaving.DebugLog;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenter splashPresenter = new SplashPresenterImpl();

    @BindView(R.id.activity_splash_progress_bar)
    ContentLoadingProgressBar progressBar;

    @BindView(R.id.splash_error_view)
    TextView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
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

    @DebugLog
    @Override
    public void goToMainScreen() {
        Navigator.goToInfoScreen(this);
        finish();
    }

    @DebugLog
    @Override
    public void goToProfileScreen() {
        Navigator.goToProfileScreen(this);
        finish();
    }

    @Override
    public void showError(@NonNull Error error) {
        errorView.setText(error.getErrorMessage());
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.show();
    }

    @Override
    public void hideProgress() {
        progressBar.hide();
    }
}
