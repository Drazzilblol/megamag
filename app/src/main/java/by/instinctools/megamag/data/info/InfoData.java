package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import by.instinctools.megamag.data.info.items.InfoItem;

@AutoValue
public abstract class InfoData {

    @NonNull
    public abstract String getInfoId();

    @Nullable
    public abstract String getTitle();

    @NonNull
    public abstract List<InfoData> getInfoList();

    @NonNull
    public abstract List<InfoItem> getItemList();

    @NonNull
    public static InfoData.Builder builder() {
        return new AutoValue_InfoData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract InfoData.Builder infoId(@NonNull String value);

        public abstract InfoData.Builder title(@Nullable String value);

        public abstract InfoData.Builder itemList(@NonNull List<InfoItem> list);

        public abstract InfoData.Builder infoList(@NonNull List<InfoData> list);

        public abstract InfoData build();
    }
}
