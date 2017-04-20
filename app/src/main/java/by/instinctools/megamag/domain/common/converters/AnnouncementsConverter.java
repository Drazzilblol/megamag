package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.announcements.AnnouncementData;
import by.instinctools.megamag.domain.models.Announcement;

public class AnnouncementsConverter extends BaseConverter<AnnouncementData, Announcement> {

    @NonNull
    @Override
    public Announcement convert(@NonNull AnnouncementData announcementData) {
        return Announcement.create(
                announcementData.getTitle(),
                announcementData.getPlace(),
                announcementData.getDetails(),
                announcementData.getDescription(),
                announcementData.getCoverUri()
        );
    }

}
