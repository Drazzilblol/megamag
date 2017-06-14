package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.auth.UserData;
import by.instinctools.megamag.domain.models.User;

public class UserConverter extends BaseConverter<UserData, User> {

    @NonNull
    @Override
    public User convert(@NonNull UserData userData) {
        return User.builder()
                .login(userData.getLogin())
                .password(userData.getPassword())
                .session(userData.getSession())
                .build();
    }
}
