package by.instinctools.megamag.data.models;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TicketImpl implements Ticket {

    public static Ticket create(String title, String beginWith, String coverUri) {
        return new AutoValue_TicketImpl(title, beginWith, coverUri);
    }
}
