package by.instinctools.megamag.presentation.main.announcements;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.domain.models.AnnouncementViewModel;
import by.instinctools.megamag.presentation.main.announcements.adapter.AnnouncementsListAdapter;
import by.instinctools.megamag.presentation.main.announcements.decorator.OffsetItemDecorator;

public class AnnouncementsFragment extends Fragment implements AnnouncementsView {

    @BindView(R.id.announcements_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.announcements_error_view)
    TextView errorView;

    @BindView(R.id.announcements_progress_bar)
    View progressBar;

    @NonNull
    private AnnouncementsPresenter presenter = new AnnouncementsPresenterImpl();

    @NonNull
    private AnnouncementsListAdapter adapter = new AnnouncementsListAdapter();

    public static AnnouncementsFragment newInstance() {
        return new AnnouncementsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_announcements, container, false);
        ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false)
        );
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new OffsetItemDecorator(
                getContext(),
                R.dimen.announcement_list_item_offset)
        );
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showData(@NonNull List<AnnouncementViewModel> announcementList) {
        adapter.setAnnouncements(announcementList);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideData() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
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
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

}
