package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Ticket {

    @NonNull
    public abstract String getTitle();

    @NonNull
    public abstract String getBeginsWith();

    @Nullable
    public abstract String getCoverUrl();

    @Nullable
    public abstract String getCoverUrlLQ();

    @NonNull
    public static Ticket.Builder builder() {
        return new AutoValue_Ticket.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Ticket.Builder title(@NonNull String value);

        public abstract Ticket.Builder beginsWith(@NonNull String value);

        public abstract Ticket.Builder coverUrl(@Nullable String value);

        public abstract Ticket.Builder coverUrlLQ(@Nullable String value);

        public abstract Ticket build();
    }
}
