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
    public static Builder builder() {
        return new AutoValue_AnnouncementData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder title(@NonNull String value);

        public abstract Builder place(@NonNull String value);

        public abstract Builder details(@Nullable String value);

        public abstract Builder description(@Nullable String value);

        public abstract Builder coverUri(@Nullable String value);

        public abstract AnnouncementData build();
    }
}
