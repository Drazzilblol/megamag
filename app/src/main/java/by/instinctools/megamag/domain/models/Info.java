package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class Info {

    @NonNull
    public abstract String getInfoId();

    @Nullable
    public abstract String getTitle();

    @Nullable
    public abstract String getText();

    @NonNull
    public abstract List<Info> getInfoList();

    @NonNull
    public static Info.Builder builder() {
        return new AutoValue_Info.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Info.Builder infoId(@NonNull String value);

        public abstract Info.Builder title(@Nullable String value);

        public abstract Info.Builder text(@Nullable String value);

        public abstract Info.Builder infoList(@NonNull List<Info> list);

        public abstract Info build();
    }
}
