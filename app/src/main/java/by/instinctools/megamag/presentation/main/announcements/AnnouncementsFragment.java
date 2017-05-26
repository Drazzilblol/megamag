package by.instinctools.megamag.presentation.main.announcements;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.presentation.common.decorator.OffsetItemDecorator;
import by.instinctools.megamag.presentation.main.announcements.adapter.AnnouncementsListAdapter;
import hugo.weaving.DebugLog;

public class AnnouncementsFragment extends Fragment implements AnnouncementsView {

    @BindView(R.id.announcements_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.announcements_error_view)
    TextView errorView;

    @BindView(R.id.announcements_progress_bar)
    ContentLoadingProgressBar progressBar;

    @NonNull
    private AnnouncementsPresenter presenter = new AnnouncementsPresenterImpl();

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
        initRecyclerView();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setAnnouncements(getStubAnnouncements());
            }
        }, 2000);

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
        progressBar.show();
    }

    @Override
    public void hideProgress() {
        progressBar.hide();
    }

    private List<Announcement> getStubAnnouncements() {
        List<Announcement> announcements = new ArrayList<>();
        announcements.add(Announcement.builder()
                .title("Затерянный город Z1")
                .place("Анонсы")
                .details("США (2016) боевик, драма, приключения, биография, история")
                .description("Эльдорадо, таинственная столица инков, загадочный Город Z… Вымысел или реальность? В 1925 году экспедиция полковника Фоссета, члена Королевского Географического общества, бесследно исчезла в джунглях Амазонии в поисках Города Z…")
                .coverUrl("http://kinoteatr.megamag.by/images/newsdesk_img/zateryanniy_gorod_b1.jpg")
                .build()
        );

        announcements.add(Announcement.builder()
                .title("Затерянный город Z2")
                .place("Анонсы")
                .details("США (2016) боевик, драма, приключения, биография, история")
                .description("Эльдорадо, таинственная столица инков, загадочный Город Z… Вымысел или реальность? В 1925 году экспедиция полковника Фоссета, члена Королевского Географического общества, бесследно исчезла в джунглях Амазонии в поисках Города Z…")
                .coverUrl("http://kinoteatr.megamag.by/images/newsdesk_img/zateryanniy_gorod_b1.jpg")
                .build()
        );
        
        announcements.add(Announcement.builder()
                .title("Затерянный город Z4")
                .place("Анонсы")
                .details("США (2016) боевик, драма, приключения, биография, история")
                .description("Эльдорадо, таинственная столица инков, загадочный Город Z… Вымысел или реальность? В 1925 году экспедиция полковника Фоссета, члена Королевского Географического общества, бесследно исчезла в джунглях Амазонии в поисках Города Z…")
                .coverUrl("http://kinoteatr.megamag.by/images/newsdesk_img/zateryanniy_gorod_b1.jpg")
                .build()
        );

        announcements.add(Announcement.builder()
                .title("Затерянный город Z3")
                .place("Анонсы")
                .details("США (2016) боевик, драма, приключения, биография, история")
                .description("Эльдорадо, таинственная столица инков, загадочный Город Z… Вымысел или реальность? В 1925 году экспедиция полковника Фоссета, члена Королевского Географического общества, бесследно исчезла в джунглях Амазонии в поисках Города Z…")
                .coverUrl("http://kinoteatr.megamag.by/images/newsdesk_img/zateryanniy_gorod_b1.jpg")
                .build()
        );
        return announcements;
    }
}
