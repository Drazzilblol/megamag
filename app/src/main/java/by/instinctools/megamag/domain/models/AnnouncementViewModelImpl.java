package by.instinctools.megamag.domain.models;

import by.instinctools.megamag.data.models.Announcement;

public class AnnouncementViewModelImpl implements AnnouncementViewModel {

    private String details;

    private String description;

    public AnnouncementViewModelImpl(String details, String description) {
        this.details = details;
        this.description = description;
    }

    public AnnouncementViewModelImpl(Announcement announcement) {
        this(announcement.getDetails(), announcement.getDescription());
    }

    @Override
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
