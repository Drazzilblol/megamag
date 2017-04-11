package by.instinctools.megamag.presentation.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;

public class InfoActivity extends AppCompatActivity implements InfoView {

    @NonNull
    public static final String INFO_ACTIVITY_SCREEN_ID = "INFO_ACTIVITY_SCREEN_ID";

    private InfoPresenter infoPresenter;

    public static Intent createIntent(Context context, String id) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(INFO_ACTIVITY_SCREEN_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        infoPresenter = new InfoPresenterImpl();
        infoPresenter.attach(this);
        Intent intent = getIntent();
        if (intent != null) {
            infoPresenter.setInitialValue(intent.getStringExtra(INFO_ACTIVITY_SCREEN_ID));
        }
    }

    @Override
    public void showError(@NonNull Error error) {

    }

    @Override
    public void showProgress(boolean show) {

    }
}
