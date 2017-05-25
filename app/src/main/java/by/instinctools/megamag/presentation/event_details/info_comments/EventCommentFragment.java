package by.instinctools.megamag.presentation.event_details.info_comments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.domain.models.EventComment;
import by.instinctools.megamag.presentation.common.decorator.OffsetItemDecorator;
import by.instinctools.megamag.presentation.event_details.info_comments.adapter.CommentsListAdapter;
import hugo.weaving.DebugLog;

public class EventCommentFragment extends MvpAppCompatFragment implements EventCommentView {

    @NonNull
    private static final String EVENT_ID = "EVENT_ID";

    @InjectPresenter
    EventCommentPresenter eventCommentPresenter;

    @BindView(R.id.details_comments_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.details_comments_error_view)
    TextView errorView;

    @BindView(R.id.details_comments_progress_bar)
    ContentLoadingProgressBar progressBar;

    @NonNull
    private CommentsListAdapter adapter = new CommentsListAdapter();

    public static EventCommentFragment newInstance(@NonNull String eventId) {
        EventCommentFragment fragment = new EventCommentFragment();
        Bundle args = new Bundle();
        args.putString(EVENT_ID, eventId);
        fragment.setArguments(args);
        return fragment;
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_details_comments, container, false);
        ButterKnife.bind(this, view);
        initRecyclerView();
        if (getArguments() != null) {
            eventCommentPresenter.setInitialValue(getArguments().getString(EVENT_ID));
        }
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        OffsetItemDecorator itemDecorator = new OffsetItemDecorator(
                getContext(),
                R.dimen.announcement_list_item_offset
        );
        recyclerView.addItemDecoration(itemDecorator);

        recyclerView.setAdapter(adapter);
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
    public void showData(@NonNull List<EventComment> eventComments) {
        adapter.setComments(eventComments);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideData() {
        recyclerView.setVisibility(View.GONE);
    }
}
