package by.instinctools.megamag.presentation.main.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetAnnouncementsUseCase;
import by.instinctools.megamag.domain.UseCase;
import by.instinctools.megamag.domain.models.AnnouncementViewModel;
import by.instinctools.megamag.presentation.DisposablePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class AnnouncementsPresenterImpl extends DisposablePresenter<AnnouncementsView>
        implements AnnouncementsPresenter {

    private static final int EMPTY_LIST_SIZE = 0;

    @NonNull
    UseCase<List<AnnouncementViewModel>> getAnnouncementsUseCase = new GetAnnouncementsUseCase();

    @Override
    public void attach(@NonNull AnnouncementsView view) {
        super.attach(view);
        view.showProgress();
        addDisposable(
                getAnnouncementsUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    private void onLoadSuccess(@NonNull List<AnnouncementViewModel> announcementList) {
        if (isViewAttached()) {
            if (announcementList.size() != EMPTY_LIST_SIZE) {
                AnnouncementsView view = getView();
                view.hideProgress();
                view.hideError();
                view.showData(announcementList);
            } else {
                onLoadError(new ErrorException(new NoDataError()));
            }
        }
    }

    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            AnnouncementsView view = getView();
            view.hideProgress();
            view.hideData();
            showError(throwable);
        }
    }
}
