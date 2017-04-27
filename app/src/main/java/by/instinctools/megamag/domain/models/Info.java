package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Info {

    @NonNull
    public abstract String getText();

    @NonNull
    public static Info create(String text) {
        return new AutoValue_Info(text);
    }
}
