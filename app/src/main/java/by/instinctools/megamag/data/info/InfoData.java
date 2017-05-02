package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class InfoData {

    @NonNull
    public abstract String getInfoId();

    @Nullable
    public abstract String getTitle();

    @Nullable
    public abstract String getText();

    @NonNull
    public abstract List<InfoData> getInfoList();

    @NonNull
    public static InfoData.Builder builder() {
        return new AutoValue_InfoData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract InfoData.Builder infoId(@NonNull String value);

        public abstract InfoData.Builder title(@Nullable String value);

        public abstract InfoData.Builder text(@Nullable String value);

        public abstract InfoData.Builder infoList(@NonNull List<InfoData> list);

        public abstract InfoData build();
    }
}
