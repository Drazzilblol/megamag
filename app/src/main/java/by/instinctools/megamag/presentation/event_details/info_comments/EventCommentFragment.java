package by.instinctools.megamag.presentation.event_details.info_comments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import hugo.weaving.DebugLog;

public class EventCommentFragment extends MvpAppCompatFragment {

    @NonNull
    private static final String EVENT_ID = "EVENT_ID";

    @InjectPresenter
    EventCommentPresenterImpl presenter;

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
        if (getArguments() != null) {
            presenter.setInitialValue(getArguments().getString(EVENT_ID));
        }
        return view;
    }
}
