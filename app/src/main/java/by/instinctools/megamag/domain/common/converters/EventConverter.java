package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.event_details_main.EventData;
import by.instinctools.megamag.domain.models.Event;

public class EventConverter extends BaseConverter<EventData, Event> {

    @NonNull
    @Override
    public Event convert(@NonNull EventData eventData) {
        return Event.builder()
                .title(eventData.getTitle())
                .coverUrl(eventData.getCoverUrl())
                .build();
    }
}
