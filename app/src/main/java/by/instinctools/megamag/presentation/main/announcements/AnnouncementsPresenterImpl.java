package by.instinctools.megamag.presentation.main.announcements;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetAnnouncementsUseCase;
import by.instinctools.megamag.domain.UseCase;
import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class AnnouncementsPresenterImpl extends DisposablePresenter<AnnouncementsView> {

    private static final int EMPTY_LIST_SIZE = 0;

    @NonNull
    private UseCase<List<Announcement>> getAnnouncementsUseCase = new GetAnnouncementsUseCase();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
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

    @DebugLog
    private void onLoadSuccess(@NonNull List<Announcement> announcementList) {
        if (announcementList.size() != EMPTY_LIST_SIZE) {
            AnnouncementsView view = getViewState();
            view.hideProgress();
            view.hideError();
            view.showData(announcementList);
        } else {
            onLoadError(new ErrorException(new NoDataError()));
        }
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        AnnouncementsView view = getViewState();
        view.hideProgress();
        view.hideData();
        showError(throwable);
    }
}
