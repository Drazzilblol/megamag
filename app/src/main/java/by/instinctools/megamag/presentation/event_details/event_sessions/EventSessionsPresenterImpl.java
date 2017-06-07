package by.instinctools.megamag.presentation.event_details.event_sessions;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

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
    void setInitialValue(@NonNull String eventId) {
        this.eventId = eventId;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        addDisposable(
                useCase.execute(eventId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(this::sortSessionList)
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
    private void onLoadSuccess(@NonNull List<List<EventSession>> sessions) {
        EventSessionsView view = getViewState();
        view.hideProgress();
        view.hideError();
        view.showData(sessions);
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        EventSessionsView view = getViewState();
        view.hideProgress();
        view.hideData();
        showError(throwable);
    }


    private List<List<EventSession>> sortSessionList(List<EventSession> sessionList) {
        List<List<EventSession>> sortedList = new ArrayList<>();
        String place = "";
        for (EventSession session : sessionList) {
            if (!TextUtils.equals(session.getPlace(), place)) {
                place = session.getPlace();
                String hall = "";
                for (EventSession session1 : sessionList) {
                    if (TextUtils.equals(session1.getPlace(), place) && !TextUtils.equals(session1.getHall(), hall)) {
                        hall = session1.getHall();
                        List<EventSession> list = new ArrayList<>();
                        for (EventSession session2 : sessionList) {
                            if (TextUtils.equals(session2.getPlace(), place) && TextUtils.equals(session2.getHall(), hall)) {
                                list.add(session2);
                            }
                        }
                        sortedList.add(list);
                    }
                }
            }
        }
        return sortedList;
    }
}
