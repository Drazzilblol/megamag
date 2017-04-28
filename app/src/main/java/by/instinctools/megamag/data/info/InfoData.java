package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class InfoData {

    @Nullable
    public abstract String getTitle();

    @NonNull
    public abstract String getText();

    @NonNull
    public static InfoData.Builder builder() {
        return new AutoValue_InfoData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract InfoData.Builder title(@Nullable String value);

        public abstract InfoData.Builder text(@NonNull String value);

        public abstract InfoData build();
    }
}
