package by.instinctools.megamag.presentation.event_details.info_comments;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import by.instinctools.megamag.domain.GetEventCommentUseCase;
import by.instinctools.megamag.domain.models.EventComment;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class EventCommentPresenterImpl extends EventCommentPresenter {

    private GetEventCommentUseCase useCase = new GetEventCommentUseCase();

    private String eventId;

    @Override
    void setInitialValue(String eventId) {
        this.eventId = eventId;
    }

    @DebugLog
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        EventCommentView view = getViewState();
        view.showProgress();
        addDisposable(
                useCase.execute(eventId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void onLoadSuccess(@NonNull List<EventComment> comments) {
        if (isViewAttached()) {
            EventCommentView view = getViewState();
            view.hideProgress();
            view.hideError();
            view.showData(comments);
        }
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            EventCommentView view = getViewState();
            view.hideProgress();
            view.hideData();
            showError(throwable);
        }
    }


}
