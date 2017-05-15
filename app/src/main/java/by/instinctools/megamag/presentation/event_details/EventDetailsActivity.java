package by.instinctools.megamag.presentation.event_details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.utils.ImageUtils;
import by.instinctools.megamag.domain.models.Event;

public class EventDetailsActivity extends MvpAppCompatActivity implements EventDetailsView {

    @InjectPresenter
    EventDetailsPresenterImpl presenter;

    @BindView(R.id.event_cover)
    ImageView coverView;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.event_details_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, EventDetailsActivity.class);
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

    @Override
    public void showData(@NonNull Event event) {
        ImageUtils.loadImage(this, coverView, event.getCoverUrl());
        coverView.setVisibility(View.VISIBLE);
        collapsingToolbarLayout.setTitle(event.getTitle());
        collapsingToolbarLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideData() {
        coverView.setVisibility(View.GONE);
        collapsingToolbarLayout.setVisibility(View.GONE);
    }
}
