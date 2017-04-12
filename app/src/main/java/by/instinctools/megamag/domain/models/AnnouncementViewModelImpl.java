package by.instinctools.megamag.domain.models;

public class AnnouncementViewModelImpl implements AnnouncementViewModel {

    private String details;

    private String description;

    public AnnouncementViewModelImpl(String details, String description) {
        this.details = details;
        this.description = description;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public void setDetails(String details) {

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {

    }
}
