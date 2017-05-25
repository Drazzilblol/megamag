package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventSession {

    @NonNull
    public abstract String getTime();

    @NonNull
    public abstract String getDay();

    @NonNull
    public abstract String getHall();

    @NonNull
    public abstract String getPlace();

    @NonNull
    public static EventSession.Builder builder() {
        return new AutoValue_EventSession.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract EventSession.Builder time(@NonNull String value);

        public abstract EventSession.Builder day(@NonNull String value);

        public abstract EventSession.Builder hall(@NonNull String value);

        public abstract EventSession.Builder place(@NonNull String value);

        public abstract EventSession build();
    }
}
