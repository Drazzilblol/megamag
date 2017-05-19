package by.instinctools.megamag.presentation.event_details.info_page;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import by.instinctools.megamag.domain.GetEventInfoUseCase;
import by.instinctools.megamag.domain.models.EventInfo;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class EventInfoPresenter extends DisposablePresenter<EventInfoView> {

    @NonNull
    private
    GetEventInfoUseCase getEventInfoUseCase = new GetEventInfoUseCase();

    private String eventId;

    void setInitialValue(String eventId) {
        this.eventId = eventId;
    }

    @DebugLog
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        EventInfoView view = getViewState();
        view.showProgress();
        addDisposable(
                getEventInfoUseCase.execute(eventId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void onLoadSuccess(@NonNull EventInfo eventInfo) {
        EventInfoView view = getViewState();
        view.hideProgress();
        view.hideError();
        view.showData(eventInfo);
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        EventInfoView view = getViewState();
        view.hideProgress();
        view.hideData();
        showError(throwable);
    }
}
