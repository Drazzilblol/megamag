package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class InfoData {

    @Nullable
    public abstract String getTitle();

    @NonNull
    public abstract String getText();

    @NonNull
    public static InfoData create(@NonNull String title, @NonNull String text) {
        return new AutoValue_InfoData(title, text);
    }
}
