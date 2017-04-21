package by.instinctools.megamag.data.announcements;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AnnouncementData {

    public abstract String getTitle();

    public abstract String getPlace();

    public abstract String getDetails();

    public abstract String getDescription();

    public abstract String getCoverUri();

    static Builder builder() {
        return new AutoValue_AnnouncementData.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder title(String value);
        abstract Builder place(String value);
        abstract Builder details(String value);
        abstract Builder description(String value);
        abstract Builder coverUri(String value);
        abstract AnnouncementData build();
    }
}
