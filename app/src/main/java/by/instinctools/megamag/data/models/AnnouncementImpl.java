package by.instinctools.megamag.data.models;

import android.support.annotation.Nullable;

public class AnnouncementImpl implements Announcement {

    @Nullable
    private String details;

    @Nullable
    private String description;

    public AnnouncementImpl(@Nullable String details, @Nullable String description) {
        this.details = details;
        this.description = description;
    }

    @Nullable
    public String getDetails() {
        return details;
    }

    public void setDetails(@Nullable String details) {
        this.details = details;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
}
