package by.instinctools.megamag.presentation.event_details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.arellomobile.mvp.presenter.ProvidePresenterTag;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoIdError;
import by.instinctools.megamag.common.utils.ImageUtils;
import by.instinctools.megamag.domain.models.Event;
import by.instinctools.megamag.presentation.event_details.adapter.DetailsPageAdapter;

public class EventDetailsActivity extends MvpAppCompatActivity implements EventDetailsView {

    @NonNull
    private static final String EVENT_DETAILS_ID = "EVENT_DETAILS_ID";

    @InjectPresenter
    EventDetailsPresenter presenter;

    @BindView(R.id.event_cover)
    ImageView coverView;

    @BindView(R.id.event_details_view_pager)
    ViewPager viewPager;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @ProvidePresenterTag(presenterClass = EventDetailsPresenter.class)
    String provideEventDetailsPresenterTag() {
        return String.format("%s:id=%s", EventDetailsPresenter.class.getSimpleName(), getInfoIdFromIntent());
    }

    @ProvidePresenter
    EventDetailsPresenter provideEventDetailsPresenter() {
        return new EventDetailsPresenter(getInfoIdFromIntent());
    }

    private String getInfoIdFromIntent() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EVENT_DETAILS_ID)) {
            return intent.getStringExtra(EVENT_DETAILS_ID);
        } else {
            throw new ErrorException(new NoIdError());
        }
    }

    public static Intent createIntent(@NonNull Context context, @NonNull String id) {
        Intent intent = new Intent(context, EventDetailsActivity.class);
        intent.putExtra(EVENT_DETAILS_ID, id);
        return intent;
    }

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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
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
        ImageUtils.loadImageWithBlur(this, coverView, event.getCoverUrl());
        coverView.setVisibility(View.VISIBLE);
        collapsingToolbarLayout.setTitle(event.getTitle());
        collapsingToolbarLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void initPagerFragments(@NonNull String eventId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentStatePagerAdapter pagerAdapter = new DetailsPageAdapter(fragmentManager, eventId);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_details_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void hideData() {
        coverView.setVisibility(View.GONE);
        collapsingToolbarLayout.setVisibility(View.GONE);
    }
}
