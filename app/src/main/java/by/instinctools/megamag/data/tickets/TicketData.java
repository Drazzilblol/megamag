package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TicketData {

    @NonNull
    public abstract String getTitle();

    @NonNull
    public abstract String getBeginsWith();

    @Nullable
    public abstract String getCoverUrl();

    @Nullable
    public abstract String getCoverUrlLQ();

    @NonNull
    public abstract String getEventId();

    @NonNull
    public static TicketData.Builder builder() {
        return new AutoValue_TicketData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract TicketData.Builder title(@NonNull String value);

        public abstract TicketData.Builder beginsWith(@NonNull String value);

        public abstract TicketData.Builder coverUrl(@Nullable String value);

        public abstract TicketData.Builder coverUrlLQ(@Nullable String value);

        public abstract TicketData.Builder eventId(@NonNull String value);

        public abstract TicketData build();
    }
}
