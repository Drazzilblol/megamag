package by.instinctools.megamag.domain.models;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import by.instinctools.megamag.data.type.GroupType;
import by.instinctools.megamag.data.type.ItemType;

@AutoValue
public abstract class Menu {

    @NonNull
    public abstract String getTitle();

    @NonNull
    public abstract ItemType getType();

    @NonNull
    public abstract GroupType getGroupType();

    @DrawableRes
    public abstract int getIcon();

    @NonNull
    public static Menu.Builder builder() {
        return new AutoValue_Menu.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Menu.Builder title(@NonNull String value);

        public abstract Menu.Builder type(@NonNull ItemType value);

        public abstract Menu.Builder groupType(@NonNull GroupType value);

        public abstract Menu.Builder icon(@DrawableRes int value);

        public abstract Menu build();
    }
}
