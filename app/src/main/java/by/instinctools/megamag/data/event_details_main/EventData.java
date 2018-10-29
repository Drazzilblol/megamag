package by.instinctools.megamag.data.event_details_main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventData {

    @NonNull
    public abstract String getTitle();

    @Nullable
    public abstract String getCoverUrl();

    @NonNull
    public static EventData.Builder builder() {
        return new AutoValue_EventData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract EventData.Builder title(@NonNull String value);

        public abstract EventData.Builder coverUrl(@Nullable String value);

        public abstract EventData build();
    }
}
