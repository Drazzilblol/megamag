package by.instinctools.megamag.data.announcements;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AnnouncementData {

    public abstract String getTitle();

    public abstract String getPlace();

    public abstract String getDetails();

    public abstract String getDescription();

    public abstract String getCoverUri();

    public static AnnouncementData create(String title, String place, String details, String description, String coverUri) {
        return new AutoValue_AnnouncementData(title, place, details, description, coverUri);
    }
}
