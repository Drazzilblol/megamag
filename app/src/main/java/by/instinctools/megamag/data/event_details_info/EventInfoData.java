package by.instinctools.megamag.data.event_details_info;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventInfoData {
    @Nullable
    public abstract String getDetails();

    @Nullable
    public abstract String getDescription();

    @Nullable
    public abstract String getTrailerUrl();

    @NonNull
    public static EventInfoData.Builder builder() {
        return new AutoValue_EventInfoData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract EventInfoData.Builder details(@Nullable String value);

        public abstract EventInfoData.Builder description(@Nullable String value);

        public abstract EventInfoData.Builder trailerUrl(@Nullable String value);

        public abstract EventInfoData build();
    }
}
