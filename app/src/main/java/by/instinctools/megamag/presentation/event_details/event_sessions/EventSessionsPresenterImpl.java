package by.instinctools.megamag.presentation.event_details.event_sessions;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetEventSessionUseCase;
import by.instinctools.megamag.domain.models.EventSession;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class EventSessionsPresenterImpl extends EventSessionsPresenter {

    private String eventId;

    @NonNull
    private GetEventSessionUseCase useCase = new GetEventSessionUseCase();

    @Override
    void setInitialValue(String eventId) {
        this.eventId = eventId;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
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
    @Override
    public void attachView(@NonNull EventSessionsView view) {
        super.attachView(view);
        view.showProgress();
    }

    @DebugLog
    private void onLoadSuccess(@NonNull List<EventSession> event) {
        if (isViewAttached()) {
            EventSessionsView view = getViewState();
            view.hideProgress();
            view.hideError();
            //  view.showData(event);
        } else {
            onLoadError(new ErrorException(new NoDataError()));
        }
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            EventSessionsView view = getViewState();
            view.hideProgress();
            view.hideData();
            showError(throwable);
        }
    }
}
