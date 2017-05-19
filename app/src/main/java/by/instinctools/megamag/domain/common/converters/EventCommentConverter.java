package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.event_details_comments.EventCommentData;
import by.instinctools.megamag.data.event_details_info.EventInfoData;
import by.instinctools.megamag.domain.models.EventComment;
import by.instinctools.megamag.domain.models.EventInfo;

public class EventCommentConverter extends BaseConverter<EventCommentData, EventComment> {

    @NonNull
    @Override
    public EventComment convert(@NonNull EventCommentData eventCommentData) {
        return EventComment.builder()
                .text(eventCommentData.getText())
                .userName(eventCommentData.getUserName())
                .avatarUrl(eventCommentData.getAvatarUrl())
                .build();
    }
}
