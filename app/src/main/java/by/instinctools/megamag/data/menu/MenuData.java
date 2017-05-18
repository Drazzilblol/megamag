package by.instinctools.megamag.data.menu;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MenuData {

    @NonNull
    public abstract String getTitle();

    public abstract int getMenuId();

    public abstract int getTargetId();

    @DrawableRes
    public abstract int getIcon();

    @NonNull
    public static MenuData.Builder builder() {
        return new AutoValue_MenuData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract MenuData.Builder title(@NonNull String value);

        public abstract MenuData.Builder menuId(int value);

        public abstract MenuData.Builder targetId(int value);

        public abstract MenuData.Builder icon(@DrawableRes int value);

        public abstract MenuData build();
    }
}
