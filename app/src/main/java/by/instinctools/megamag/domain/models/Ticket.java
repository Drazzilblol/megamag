package by.instinctools.megamag.domain.models;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Ticket {

    public abstract String getTitle();

    public abstract String getBeginsWith();

    public abstract String getCoverUri();

    public static Ticket create(String title, String beginWith, String coverUri) {
        return new AutoValue_Ticket(title, beginWith, coverUri);
    }
}
