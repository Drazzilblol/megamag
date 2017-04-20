package by.instinctools.megamag.domain.models;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AnnouncementViewModelImpl implements AnnouncementViewModel {

    public static AnnouncementViewModel create(String details, String description) {
        return new AutoValue_AnnouncementViewModelImpl(details, description);
    }
}
