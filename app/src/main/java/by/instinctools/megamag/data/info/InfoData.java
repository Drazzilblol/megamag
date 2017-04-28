package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.ArrayList;
import java.util.List;

@AutoValue
public abstract class InfoData {

    @NonNull
    private List<InfoData> infoList = new ArrayList<>();

    @Nullable
    public abstract String getTitle();

    @NonNull
    public abstract String getText();

    @NonNull
    public List<InfoData> getInfoList() {
        return infoList;
    }

    public void addToInfoList(InfoData infoData) {
        infoList.add(infoData);
    }

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
