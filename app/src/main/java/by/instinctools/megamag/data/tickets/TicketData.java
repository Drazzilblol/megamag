package by.instinctools.megamag.data.tickets;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TicketData {

    public abstract String getTitle();

    public abstract String getBeginWith();

    public abstract String getCoverUri();

    public static TicketData create(String title, String beginWith, String coverUri) {
        return new AutoValue_TicketData(title, beginWith, coverUri);
    }
}
