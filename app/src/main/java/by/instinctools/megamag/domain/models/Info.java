package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.ArrayList;
import java.util.List;

@AutoValue
public abstract class Info {

    @NonNull
    private List<Info> infoList = new ArrayList<>();

    @NonNull
    public abstract String getInfoId();

    @Nullable
    public abstract String getTitle();

    @NonNull
    public abstract String getText();

    @NonNull
    public List<Info> getInfoList() {
        return infoList;
    }

    public void addToInfoList(Info info) {
        infoList.add(info);
    }

    @NonNull
    public static Info.Builder builder() {
        return new AutoValue_Info.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Info.Builder infoId(@NonNull String value);

        public abstract Info.Builder title(@Nullable String value);

        public abstract Info.Builder text(@NonNull String value);

        public abstract Info build();
    }
}
