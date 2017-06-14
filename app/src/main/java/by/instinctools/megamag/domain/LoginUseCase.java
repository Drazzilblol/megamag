package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.converters.ListConverter;
import by.instinctools.megamag.data.auth.UserData;
import by.instinctools.megamag.data.auth.UserRepository;
import by.instinctools.megamag.data.auth.UserRepositoryImpl;
import by.instinctools.megamag.data.tickets.TicketData;
import by.instinctools.megamag.data.tickets.TicketRepository;
import by.instinctools.megamag.data.tickets.TicketRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.TicketsConverter;
import by.instinctools.megamag.domain.common.converters.UserConverter;
import by.instinctools.megamag.domain.models.Ticket;
import by.instinctools.megamag.domain.models.User;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class LoginUseCase implements UseCase<User> {

    @NonNull
    private UserRepository userRepository = new UserRepositoryImpl();

    @NonNull
    private UserConverter converter = new UserConverter();

    @DebugLog
    @Override
    public Observable<User> execute() {
       throw new UnsupportedOperationException();
    }

    @DebugLog
    public Observable<User> execute(@NonNull String login, @NonNull String password) {
        return userRepository.login(login, password)
                .map(converter::convert);
    }
}
