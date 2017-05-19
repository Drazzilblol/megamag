package by.instinctools.megamag.presentation.event_details.info_page;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.domain.models.EventInfo;
import hugo.weaving.DebugLog;

public class EventInfoFragment extends MvpAppCompatFragment implements EventInfoView {

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

    public static EventInfoFragment newInstance() {
        return new EventInfoFragment();
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
