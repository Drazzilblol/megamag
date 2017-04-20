package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseListConverter;
import by.instinctools.megamag.data.tickets.TicketData;
import by.instinctools.megamag.domain.models.Ticket;

public class TicketsListConverter extends BaseListConverter<TicketData, Ticket> {

    @NonNull
    @Override
    public Ticket convert(@NonNull TicketData ticketData) {
        return Ticket.create(
                ticketData.getTitle(),
                ticketData.getBeginWith(),
                ticketData.getCoverUri()
        );
    }
}
