package by.instinctools.megamag.data.auth;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

public class UserRepositoryImpl implements UserRepository {

    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();

    @NonNull
    @Override
    public Observable<UserData> login(@NonNull String login, @NonNull String password) {
        return userRemoteDataSource.login(login, password);
    }
}
