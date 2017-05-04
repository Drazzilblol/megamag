package by.instinctools.megamag.data.info.items;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import by.instinctools.megamag.data.info.InfoData;

@AutoValue
public abstract class InfoImage implements InfoItem {

    @NonNull
    public abstract String getImageUrl();

    @NonNull
    public static InfoImage.Builder builder() {
        return new AutoValue_InfoImage.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract InfoImage.Builder imageUrl(@NonNull String value);

        public abstract InfoImage build();
    }
}
