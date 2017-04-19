package by.instinctools.megamag.data.models;

public class TicketImpl implements Ticket {

    private String title;
    private String beginsWith;
    private String coverUri;

    public TicketImpl(String title, String beginsWith, String coverUri) {
        this.title = title;
        this.beginsWith = beginsWith;
        this.coverUri = coverUri;
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
