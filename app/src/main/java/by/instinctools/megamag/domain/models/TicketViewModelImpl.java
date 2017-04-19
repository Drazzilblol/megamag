package by.instinctools.megamag.domain.models;

import by.instinctools.megamag.data.models.Ticket;

public class TicketViewModelImpl implements TicketViewModel {

    private String title;
    private String beginsWith;
    private String coverUri;

    private TicketViewModelImpl(String title, String beginsWith, String coverUri) {
        this.title = title;
        this.beginsWith = beginsWith;
        this.coverUri = coverUri;
    }

    public TicketViewModelImpl(Ticket ticket) {
        this(ticket.getTitle(), ticket.getBeginsWith(), ticket.getCoverUri());
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getBeginsWith() {
        return beginsWith;
    }

    @Override
    public String getCoverUri() {
        return coverUri;
    }
}
