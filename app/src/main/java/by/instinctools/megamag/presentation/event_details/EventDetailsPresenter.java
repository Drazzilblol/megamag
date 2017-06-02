package by.instinctools.megamag.presentation.event_details;


import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import by.instinctools.megamag.domain.GetEventUseCase;
import by.instinctools.megamag.domain.models.Event;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class EventDetailsPresenter extends DisposablePresenter<EventDetailsView> {

    private String eventId;

    @NonNull
    private GetEventUseCase getEventUseCase = new GetEventUseCase();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        addDisposable(
                getEventUseCase.execute(eventId)
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
    public void attachView(@NonNull EventDetailsView view) {
        super.attachView(view);
        view.showProgress();
    }

    @DebugLog
    private void onLoadSuccess(@NonNull Event event) {
        EventDetailsView view = getViewState();
        view.hideProgress();
        view.hideError();
        view.showData(event);
    }

    public void setInitialValue(@NonNull String eventId) {
        this.eventId = eventId;
        getViewState().initPagerFragments(eventId);
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        EventDetailsView view = getViewState();
        view.hideProgress();
        view.hideData();
        showError(throwable);
    }
}
