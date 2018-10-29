package by.instinctools.megamag.presentation.event_details.event_info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.arellomobile.mvp.presenter.ProvidePresenterTag;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoIdError;
import by.instinctools.megamag.domain.models.EventInfo;
import hugo.weaving.DebugLog;

public class EventInfoFragment extends MvpAppCompatFragment implements EventInfoView {

    @NonNull
    private static final String EVENT_ID = "EVENT_ID";

    @BindView(R.id.details_info_details_view)
    TextView detailsView;

    @BindView(R.id.details_info_description_view)
    TextView descriptionView;

    @BindView(R.id.details_info_error_view)
    TextView errorView;

    @BindView(R.id.details_info_progress_bar)
    ContentLoadingProgressBar progressBar;

    @InjectPresenter
    EventInfoPresenter presenter;

    public static EventInfoFragment newInstance(@NonNull String eventId) {
        EventInfoFragment fragment = new EventInfoFragment();
        Bundle args = new Bundle();
        args.putString(EVENT_ID, eventId);
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenterTag(presenterClass = EventInfoPresenter.class)
    String provideEventInfoPresenterTag() {
        return String.format("%s:id=%s", EventInfoPresenter.class.getSimpleName(), getEventIdFromArguments());
    }

    @ProvidePresenter
    EventInfoPresenter provideEventInfoPresenter() {
        return new EventInfoPresenter(getEventIdFromArguments());
    }

    private String getEventIdFromArguments() {
        Bundle args = getArguments();
        if (args != null && args.containsKey(EVENT_ID)) {
            return getArguments().getString(EVENT_ID);
        } else {
            throw new ErrorException(new NoIdError());
        }
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_details_info, container, false);
        ButterKnife.bind(this, view);
        return view;
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

    @Override
    public void showData(@NonNull EventInfo eventInfo) {
        descriptionView.setText(eventInfo.getDescription());
        detailsView.setText(eventInfo.getDetails());
        detailsView.setVisibility(View.VISIBLE);
        descriptionView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideData() {
        detailsView.setVisibility(View.GONE);
        descriptionView.setVisibility(View.GONE);
    }
}