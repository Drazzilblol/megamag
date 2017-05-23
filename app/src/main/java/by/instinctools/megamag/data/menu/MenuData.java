package by.instinctools.megamag.data.menu;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import by.instinctools.megamag.data.type.GroupType;
import by.instinctools.megamag.data.type.ItemType;

@AutoValue
public abstract class MenuData {

    @NonNull
    public abstract String getTitle();

    @NonNull
    public abstract ItemType getType();

    @NonNull
    public abstract GroupType getGroupType();

    @DrawableRes
    public abstract int getIcon();

    @NonNull
    public static MenuData.Builder builder() {
        return new AutoValue_MenuData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract MenuData.Builder title(@NonNull String value);

        public abstract MenuData.Builder type(@NonNull ItemType value);

        public abstract MenuData.Builder groupType(@NonNull GroupType value);

        public abstract MenuData.Builder icon(@DrawableRes int value);

        public abstract MenuData build();
    }
}
