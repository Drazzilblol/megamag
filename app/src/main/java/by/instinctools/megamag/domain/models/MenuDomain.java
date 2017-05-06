package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MenuDomain {

    @NonNull
    public abstract String getTitle();

    public abstract int getMenuId();

    public abstract int getTargetId();

    @NonNull
    public static MenuDomain.Builder builder() {
        return new AutoValue_MenuDomain.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract MenuDomain.Builder title(@NonNull String value);

        public abstract MenuDomain.Builder menuId(int value);

        public abstract MenuDomain.Builder targetId(int value);

        public abstract MenuDomain build();
    }
}
