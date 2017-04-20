package by.instinctools.megamag.domain.models;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Announcement {

    public abstract String getTitle();

    public abstract String getPlace();

    public abstract String getDetails();

    public abstract String getDescription();

    public abstract String getCoverUri();

    public static Announcement create(String title, String place, String details, String description, String coverUri) {
        return new AutoValue_Announcement(title, place, details, description, coverUri);
    }
}
