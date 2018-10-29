package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventInfo {

    @Nullable
    public abstract String getDetails();

    @Nullable
    public abstract String getDescription();

    @Nullable
    public abstract String getTrailerUrl();

    @NonNull
    public static EventInfo.Builder builder() {
        return new AutoValue_EventInfo.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract EventInfo.Builder details(@Nullable String value);

        public abstract EventInfo.Builder description(@Nullable String value);

        public abstract EventInfo.Builder trailerUrl(@Nullable String value);

        public abstract EventInfo build();
    }
}
