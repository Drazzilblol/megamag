package by.instinctools.megamag.presentation.main.announcements;

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
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.presentation.common.decorator.OffsetItemDecorator;
import by.instinctools.megamag.presentation.main.OnFragmentCreatedListener;
import by.instinctools.megamag.presentation.main.announcements.adapter.AnnouncementsListAdapter;
import hugo.weaving.DebugLog;

public class AnnouncementsFragment extends MvpAppCompatFragment implements AnnouncementsView {

    @BindView(R.id.announcements_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.announcements_error_view)
    TextView errorView;

    @BindView(R.id.announcements_progress_bar)
    ContentLoadingProgressBar progressBar;

    @InjectPresenter(type = PresenterType.GLOBAL)
    AnnouncementsPresenter announcementsPresenter;

    @NonNull
    private AnnouncementsListAdapter adapter = new AnnouncementsListAdapter();

    public static AnnouncementsFragment newInstance() {
        return new AnnouncementsFragment();
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_announcements, container, false);
        ButterKnife.bind(this, view);
        ((OnFragmentCreatedListener) getActivity()).onFragmentCreated(getString(R.string.announcements_toolbar_title));
        initRecyclerView();
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
    public void showData(@NonNull List<Announcement> announcementList) {
        adapter.changeItems(announcementList);
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
