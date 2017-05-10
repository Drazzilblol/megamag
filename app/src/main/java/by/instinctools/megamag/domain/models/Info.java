package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import by.instinctools.megamag.data.info.items.InfoItem;

@AutoValue
public abstract class Info {

    public abstract int getInfoId();

    @Nullable
    public abstract String getTitle();

    @NonNull
    public abstract List<Info> getInfoList();

    @NonNull
    public abstract List<InfoItem> getItemList();

    @Nullable
    public abstract String getType();

    @NonNull
    public static Info.Builder builder() {
        return new AutoValue_Info.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Info.Builder infoId(int value);

        public abstract Info.Builder title(@Nullable String value);

        public abstract Info.Builder itemList(@NonNull List<InfoItem> list);

        public abstract Info.Builder infoList(@NonNull List<Info> list);

        public abstract Info.Builder type(@Nullable String value);

        public abstract Info build();
    }
}
