package by.instinctools.megamag.data.auth;

import android.support.annotation.NonNull;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.data.BaseRemoteDataSource;
import io.reactivex.Observable;

public class UserRemoteDataSource extends BaseRemoteDataSource<String, UserData> {

    Observable<UserData> login(@NonNull String login, @NonNull String password){

        return Application.getApi()
                .login("Paskalj10@gmail.com", "drazzilblol01")
                .map(UserParser::parseUser);
    }

}
