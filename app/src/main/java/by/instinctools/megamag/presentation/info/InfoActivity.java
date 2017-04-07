package by.instinctools.megamag.presentation.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;

public class InfoActivity extends AppCompatActivity implements InfoView {
    public static final String INFO_ACTIVITY_SCREEN_ID = "INFO_ACTIVITY_SCREEN_ID";

    private InfoPresenter infoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        infoPresenter = new InfoPresenterImpl();
        infoPresenter.attach(this);
        infoPresenter.onCreate(InfoPresenter.CONTACT_US);
    }

    @Override
    public void setText() {

    }

    public static Intent newIntent(Context context, String id){
        Intent i = new Intent(context, InfoActivity.class);
        i.putExtra(INFO_ACTIVITY_SCREEN_ID, id);
        return i;
    }

    @Override
    public void showError(Error error) {

    }

    @Override
    public void showProgress(boolean show) {

    }
}
