package by.instinctools.megamag.data.event_details_session;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventSessionData {

    @NonNull
    public abstract String getTime();

    @NonNull
    public abstract String getDay();

    @NonNull
    public abstract String getHall();

    @NonNull
    public abstract String getPlace();

    @NonNull
    public static EventSessionData.Builder builder() {
        return new AutoValue_EventSessionData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract EventSessionData.Builder time(@NonNull String value);

        public abstract EventSessionData.Builder day(@NonNull String value);

        public abstract EventSessionData.Builder hall(@NonNull String value);

        public abstract EventSessionData.Builder place(@NonNull String value);

        public abstract EventSessionData build();
    }
}
