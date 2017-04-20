package by.instinctools.megamag.domain.models;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TicketViewModelImpl implements TicketViewModel {

    public static TicketViewModel create(String title, String beginWith, String coverUri) {
        return new AutoValue_TicketViewModelImpl(title, beginWith, coverUri);
    }
}
