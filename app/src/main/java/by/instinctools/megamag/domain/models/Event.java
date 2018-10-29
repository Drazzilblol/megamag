package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Event {

    @NonNull
    public abstract String getTitle();

    @Nullable
    public abstract String getCoverUrl();

    @NonNull
    public static Event.Builder builder() {
        return new AutoValue_Event.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Event.Builder title(@NonNull String value);

        public abstract Event.Builder coverUrl(@Nullable String value);

        public abstract Event build();
    }
}
