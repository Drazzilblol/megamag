package by.instinctools.megamag.data.info.items;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class InfoText implements InfoItem {

    @NonNull
    public static InfoText.Builder builder() {
        return new AutoValue_InfoText.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract InfoText.Builder data(@NonNull String value);

        public abstract InfoText build();
    }
}
