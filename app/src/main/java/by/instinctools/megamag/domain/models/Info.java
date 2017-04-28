package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Info {

    @Nullable
    public abstract String getTitle();

    @NonNull
    public abstract String getText();

    @NonNull
    public static Info create(@NonNull String title, @NonNull String text) {
        return new AutoValue_Info(title, text);
    }
}
