package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Ticket {

    @NonNull
    public abstract String getTitle();

    @NonNull
    public abstract String getBeginsWith();

    @NonNull
    public abstract String getCoverUri();

    public static Ticket create(String title, String beginWith, String coverUri) {
        return new AutoValue_Ticket(title, beginWith, coverUri);
    }
}
