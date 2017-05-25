package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.event_details_session.EventSessionData;
import by.instinctools.megamag.domain.models.EventSession;

public class EventSessionConverter extends BaseConverter<EventSessionData, EventSession> {

    @NonNull
    @Override
    public EventSession convert(@NonNull EventSessionData eventSessionData) {
        return EventSession.builder()
                .time(eventSessionData.getTime())
                .place(eventSessionData.getPlace())
                .hall(eventSessionData.getHall())
                .day(eventSessionData.getDay())
                .build();
    }
}
