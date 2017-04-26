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

    @NonNull
    public abstract String getCoverUrl();

    @NonNull
    public static Ticket.Builder builder() {
        return new AutoValue_Ticket.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Ticket.Builder title(@NonNull String value);

        public abstract Ticket.Builder beginsWith(@NonNull String value);

        public abstract Ticket.Builder coverUrl(@Nullable String value);

        public abstract Ticket build();
    }
}
