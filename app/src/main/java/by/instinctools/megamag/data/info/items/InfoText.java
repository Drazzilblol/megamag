package by.instinctools.megamag.data.info.items;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class InfoText implements InfoItem {

    @NonNull
    public abstract String getText();

    @NonNull
    public static InfoText.Builder builder() {
        return new AutoValue_Infotext.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract InfoText.Builder text(@NonNull String value);

        public abstract InfoText build();
    }
}
