package by.instinctools.megamag.presentation.main.tickets;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetTicketsUseCase;
import by.instinctools.megamag.domain.UseCase;
import by.instinctools.megamag.domain.models.Ticket;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class TicketsPresenter extends DisposablePresenter<TicketsView> {

    private static final int EMPTY_LIST_SIZE = 0;

    @NonNull
    private UseCase<List<Ticket>> getTicketsUseCase = new GetTicketsUseCase();

    @Override
    protected void onFirstViewAttach() {
        getViewState().showProgress();
        loadTickets();
    }

    private void loadTickets() {
        addDisposable(
                getTicketsUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void onLoadSuccess(@NonNull List<Ticket> ticketsList) {
        if (ticketsList.size() != EMPTY_LIST_SIZE) {
            TicketsView view = getViewState();
            view.hideProgress();
            view.hideError();
            view.showData(ticketsList);
        } else {
            onLoadError(new ErrorException(new NoDataError()));
        }
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        TicketsView view = getViewState();
        view.hideProgress();
        view.hideData();
        showError(throwable);
    }

    void onTicketItemClick(@NonNull String detailsId) {
        getViewState().goToDetailsScreen(detailsId);
    }
}
