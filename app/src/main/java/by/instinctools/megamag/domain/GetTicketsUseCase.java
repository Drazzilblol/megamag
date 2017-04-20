package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.tickets.TicketRepository;
import by.instinctools.megamag.data.tickets.TicketRepositoryImpl;
import by.instinctools.megamag.domain.models.TicketViewModel;
import by.instinctools.megamag.domain.models.TicketViewModelImpl;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class GetTicketsUseCase implements UseCase<List<TicketViewModel>> {

    @NonNull
    private TicketRepository ticketRepository = new TicketRepositoryImpl();

    @DebugLog
    @Override
    public Observable<List<TicketViewModel>> execute() {
        return ticketRepository.getTicketList()
                .flatMap(Observable::fromIterable)
                .map(TicketViewModelImpl::new)
                .map(ticket -> (TicketViewModel) ticket)
                .toList()
                .toObservable();
    }
}
