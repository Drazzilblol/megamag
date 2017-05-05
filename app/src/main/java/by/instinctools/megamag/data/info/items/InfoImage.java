package by.instinctools.megamag.data.info.items;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class InfoImage implements InfoItem {

    @NonNull
    public abstract String getData();

    @NonNull
    public static InfoImage.Builder builder() {
        return new AutoValue_InfoImage.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract InfoImage.Builder data(@NonNull String value);

        public abstract InfoImage build();
    }
}
