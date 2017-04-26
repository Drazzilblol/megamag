package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;


@AutoValue
public abstract class Announcement {

    @NonNull
    public abstract String getTitle();

    @NonNull
    public abstract String getPlace();

    @Nullable
    public abstract String getDetails();

    @Nullable
    public abstract String getDescription();

    @Nullable
    public abstract String getCoverUrl();

    @NonNull
    public static Announcement.Builder builder() {
        return new AutoValue_Announcement.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Announcement.Builder title(@NonNull String value);

        public abstract Announcement.Builder place(@NonNull String value);

        public abstract Announcement.Builder details(@Nullable String value);

        public abstract Announcement.Builder description(@Nullable String value);

        public abstract Announcement.Builder coverUrl(@Nullable String value);

        public abstract Announcement build();
    }
}
