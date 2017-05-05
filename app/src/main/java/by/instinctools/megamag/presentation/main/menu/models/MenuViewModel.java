package by.instinctools.megamag.presentation.main.menu.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MenuViewModel {

    @NonNull
    public abstract String getTitle();

    public abstract int getMenuId();

    public abstract int getTargetId();

    @NonNull
    public static MenuViewModel.Builder builder() {
        return new AutoValue_MenuViewModel.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract MenuViewModel.Builder title(@NonNull String value);

        public abstract MenuViewModel.Builder menuId(int value);

        public abstract MenuViewModel.Builder targetId(int value);

        public abstract MenuViewModel build();
    }
}
