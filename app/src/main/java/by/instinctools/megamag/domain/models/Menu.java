package by.instinctools.megamag.domain.models;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Menu {

    @NonNull
    public abstract String getTitle();

    public abstract int getMenuId();

    public abstract int getTargetId();

    @DrawableRes
    public abstract int getIcon();

    @NonNull
    public static Menu.Builder builder() {
        return new AutoValue_Menu.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Menu.Builder title(@NonNull String value);

        public abstract Menu.Builder menuId(int value);

        public abstract Menu.Builder targetId(int value);

        public abstract Menu.Builder icon(@DrawableRes int value);

        public abstract Menu build();
    }
}
