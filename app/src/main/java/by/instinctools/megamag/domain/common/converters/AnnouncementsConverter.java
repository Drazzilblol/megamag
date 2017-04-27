package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.announcements.AnnouncementData;
import by.instinctools.megamag.domain.models.Announcement;

public class AnnouncementsConverter extends BaseConverter<AnnouncementData, Announcement> {

    @NonNull
    @Override
    public Announcement convert(@NonNull AnnouncementData announcementData) {
        return Announcement.builder()
                .title(announcementData.getTitle())
                .place(announcementData.getPlace())
                .details(announcementData.getDetails())
                .description(announcementData.getDescription())
                .coverUrl(announcementData.getCoverUrl())
                .build();
    }
}
