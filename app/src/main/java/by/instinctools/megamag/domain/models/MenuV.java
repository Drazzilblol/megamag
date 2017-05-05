package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MenuV {

    @NonNull
    public abstract String getTitle();

    public abstract int getMenuId();

    public abstract int getTargetId();

    @NonNull
    public static MenuV.Builder builder() {
        return new AutoValue_MenuV.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract MenuV.Builder title(@NonNull String value);

        public abstract MenuV.Builder menuId(int value);

        public abstract MenuV.Builder targetId(int value);

        public abstract MenuV build();
    }
}
