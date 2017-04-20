package by.instinctools.megamag.domain.models;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Announcement {

    public abstract String getDetails();

    public abstract String getDescription();

    public abstract String getCoverUri();

    public static Announcement create(String details, String description, String coverUri) {
        return new AutoValue_Announcement(details, description, coverUri);
    }
}
