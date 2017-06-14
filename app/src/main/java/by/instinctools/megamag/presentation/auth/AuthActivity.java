package by.instinctools.megamag.presentation.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;

public class AuthActivity extends MvpAppCompatActivity implements AuthView {

    @BindView(R.id.password_view)
    TextView passwordView;

    @BindView(R.id.login_view)
    TextView loginView;

    @BindView(R.id.submit_button)
    Button submitButton;

    @InjectPresenter
    AuthPresenter authPresenter;

    public static Intent createIntent(@NonNull Context context) {
        return new Intent(context, AuthActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
    }

    @Override
    public void showError(@NonNull Error error) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
