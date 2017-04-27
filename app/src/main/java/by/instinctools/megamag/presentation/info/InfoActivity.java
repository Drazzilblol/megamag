package by.instinctools.megamag.presentation.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.domain.models.Info;

public class InfoActivity extends AppCompatActivity implements InfoView {

    @NonNull
    public static final String INFO_ACTIVITY_SCREEN_ID = "INFO_ACTIVITY_SCREEN_ID";

    @BindView(R.id.info_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.info_error_view)
    TextView errorView;

    @BindView(R.id.info_progress_bar)
    ContentLoadingProgressBar progressBar;

    @NonNull
    private InfoPresenter infoPresenter = new InfoPresenterImpl();

    public static Intent createIntent(Context context, String id) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(INFO_ACTIVITY_SCREEN_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        infoPresenter.attach(this);
        Intent intent = getIntent();
        if (intent != null) {
            infoPresenter.setInitialValue(intent.getStringExtra(INFO_ACTIVITY_SCREEN_ID));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        infoPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        infoPresenter.detach();
    }

    @Override
    public void showData(@NonNull List<Info> infoList) {
      //  adapter.setAnnouncements(infoList);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideData() {
        recyclerView.setVisibility(View.GONE);
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
