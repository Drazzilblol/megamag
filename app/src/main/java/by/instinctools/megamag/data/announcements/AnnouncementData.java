package by.instinctools.megamag.data.announcements;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AnnouncementData {

    public abstract String getDetails();

    public abstract String getDescription();

    public abstract String getCoverUri();

    public static AnnouncementData create(String details, String description, String coverUri) {
        return new AutoValue_AnnouncementData(details, description, coverUri);
    }
}
