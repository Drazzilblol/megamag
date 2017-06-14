package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class User {

    @NonNull
    public abstract String getLogin();

    @NonNull
    public abstract String getPassword();

    @NonNull
    public abstract String getSession();

    @NonNull
    public static Builder builder() {
        return new AutoValue_User.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder login(@NonNull String value);

        public abstract Builder password(@NonNull String value);

        public abstract Builder session(@NonNull String value);

        public abstract User build();
    }
}
