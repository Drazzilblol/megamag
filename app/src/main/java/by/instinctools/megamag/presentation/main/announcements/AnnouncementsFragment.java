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

import java.util.List;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.data.models.Announcement;
import by.instinctools.megamag.presentation.main.announcements.adapter.AnnouncementsListAdapter;
import by.instinctools.megamag.presentation.main.announcements.decorator.OffsetItemDecorator;

public class AnnouncementsFragment extends Fragment implements AnnouncementsView {

    private LinearLayoutManager linearLayoutManager;

    private AnnouncementsListAdapter adapter;

    private RecyclerView recyclerView;

    private AnnouncementsPresenter presenter;

    public static AnnouncementsFragment newInstance() {
        return new AnnouncementsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        presenter = new AnnouncementsPresenterImpl();
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_announcements, container, false);
        return recyclerView;
    }

    @Override
    public void initRecyclerView(@NonNull List<Announcement> announcementList) {
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new OffsetItemDecorator(getContext(), R.dimen.default_padding_normal));
        adapter = new AnnouncementsListAdapter(announcementList);
        recyclerView.setAdapter(adapter);
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

    }

    @Override
    public void showProgress(boolean show) {

    }
}
