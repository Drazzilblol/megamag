package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.event_details_info.EventInfoData;
import by.instinctools.megamag.domain.models.EventInfo;

public class EventInfoConverter extends BaseConverter<EventInfoData, EventInfo> {

    @NonNull
    @Override
    public EventInfo convert(@NonNull EventInfoData eventInfoData) {
        return EventInfo.builder()
                .description(eventInfoData.getDescription())
                .details(eventInfoData.getDetails())
                .trailerUrl(eventInfoData.getTrailerUrl())
                .build();
    }
}
