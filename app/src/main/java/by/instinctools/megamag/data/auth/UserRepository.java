package by.instinctools.megamag.data.auth;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

public interface UserRepository {

    @NonNull
    public Observable<UserData> login(@NonNull String login, @NonNull String password) ;
}
