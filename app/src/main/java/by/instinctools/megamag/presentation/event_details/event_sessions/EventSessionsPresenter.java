package by.instinctools.megamag.presentation.event_details.event_sessions;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.domain.GetEventSessionUseCase;
import by.instinctools.megamag.domain.models.EventSession;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class EventSessionsPresenter extends DisposablePresenter<EventSessionsView> {

    @NonNull
    private String eventId;

    @NonNull
    private GetEventSessionUseCase useCase = new GetEventSessionUseCase();

    EventSessionsPresenter(@NonNull String eventId) {
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
    private void onLoadSuccess(@NonNull List<EventSession> sessions) {
        EventSessionsView view = getViewState();
        view.hideProgress();
        view.hideError();
        if (!sessions.isEmpty()) {
            view.showData(sessions);
        } else {
            view.showNoSessions();
        }
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        EventSessionsView view = getViewState();
        view.hideProgress();
        view.hideData();
        view.showNoSessions();
        showError(throwable);
    }
}
