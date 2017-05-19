package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.tickets.TicketData;
import by.instinctools.megamag.domain.models.Ticket;

public class TicketsConverter extends BaseConverter<TicketData, Ticket> {

    @NonNull
    @Override
    public Ticket convert(@NonNull TicketData ticketData) {
        return Ticket.builder()
                .title(ticketData.getTitle())
                .beginsWith(ticketData.getBeginsWith())
                .coverUrl(ticketData.getCoverUrl())
                .coverUrlLQ(ticketData.getCoverUrlLQ())
                .eventId(ticketData.getEventId())
                .build();
    }
}
