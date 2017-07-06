package by.instinctools.megamag.presentation.event_details.event_sessions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.arellomobile.mvp.presenter.ProvidePresenterTag;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoIdError;
import by.instinctools.megamag.domain.models.EventSession;
import by.instinctools.megamag.presentation.event_details.event_sessions.adapter.SessionsListAdapter;
import hugo.weaving.DebugLog;

public class EventSessionsFragment extends MvpAppCompatFragment implements EventSessionsView {

    @NonNull
    private static final String EVENT_ID = "EVENT_ID";

    @InjectPresenter
    EventSessionsPresenter presenter;

    @BindView(R.id.details_sessions_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.details_sessions_error_view)
    TextView errorView;

    @BindView(R.id.details_sessions_progress_bar)
    ContentLoadingProgressBar progressBar;

    @NonNull
    private SessionsListAdapter sessionsListAdapter = new SessionsListAdapter();

    public static EventSessionsFragment newInstance(@NonNull String eventId) {
        EventSessionsFragment fragment = new EventSessionsFragment();
        Bundle args = new Bundle();
        args.putString(EVENT_ID, eventId);
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenterTag(presenterClass = EventSessionsPresenter.class)
    String provideInfoPresenterTag() {
        return String.format("%s:id=%s", EventSessionsPresenter.class.getSimpleName(), getEventIdFromArguments());
    }

    @ProvidePresenter
    EventSessionsPresenter provideInfoPresenter() {
        return new EventSessionsPresenter(getEventIdFromArguments());
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_details_sessions, container, false);
        ButterKnife.bind(this, view);
        initRecyclerView();
        getEventIdFromArguments();
        return view;
    }

    private String getEventIdFromArguments() {
        Bundle args = getArguments();
        if (args != null && args.containsKey(EVENT_ID)) {
            return getArguments().getString(EVENT_ID);
        } else {
            throw new ErrorException(new NoIdError());
        }
    }

    private void initRecyclerView() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(sessionsListAdapter);

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
    public void showData(@NonNull List<List<EventSession>> eventSessions) {
        sessionsListAdapter.addItems(eventSessions);
        recyclerView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideData() {
        recyclerView.setVisibility(View.GONE);
    }
}
