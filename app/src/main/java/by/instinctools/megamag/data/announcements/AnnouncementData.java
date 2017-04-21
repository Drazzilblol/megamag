package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AnnouncementData {

    @NonNull
    public abstract String getTitle();

    @NonNull
    public abstract String getPlace();

    @Nullable
    public abstract String getDetails();

    @Nullable
    public abstract String getDescription();

    @Nullable
    public abstract String getCoverUri();

    @NonNull
    static Builder builder() {
        return new AutoValue_AnnouncementData.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {

        abstract Builder title(@NonNull String value);

        abstract Builder place(@NonNull String value);

        abstract Builder details(@Nullable String value);

        abstract Builder description(@Nullable String value);

        abstract Builder coverUri(@Nullable String value);

        abstract AnnouncementData build();
    }
}
