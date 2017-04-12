package by.instinctools.megamag.presentation.main.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.models.Announcement;
import by.instinctools.megamag.domain.GetAnnouncementsUseCase;
import by.instinctools.megamag.domain.UseCase;
import by.instinctools.megamag.presentation.DisposablePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class AnnouncementsPresenterImpl extends DisposablePresenter<AnnouncementsView>
        implements AnnouncementsPresenter {

    UseCase<List<Announcement>> getAnnouncementsUseCase = new GetAnnouncementsUseCase();

    @Override
    public void attach(@NonNull AnnouncementsView view) {
        super.attach(view);
        addDisposable(
                getAnnouncementsUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::onLoadSuccess, this::onLoadError)
        );
    }

    private void onLoadSuccess(@NonNull List<Announcement> announcementList) {
        getView().initRecyclerView(announcementList);
    }

    private void onLoadError(@NonNull Throwable throwable) {

    }
}
