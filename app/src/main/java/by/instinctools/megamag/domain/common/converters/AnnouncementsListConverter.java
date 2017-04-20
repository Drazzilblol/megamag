package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseListConverter;
import by.instinctools.megamag.data.announcements.AnnouncementData;
import by.instinctools.megamag.domain.models.Announcement;

public class AnnouncementsListConverter extends BaseListConverter<AnnouncementData, Announcement> {

    @NonNull
    @Override
    public Announcement convert(@NonNull AnnouncementData announcementData) {
        return Announcement.create(
                announcementData.getDetails(),
                announcementData.getDescription(),
                announcementData.getCoverUri()
        );
    }

}
