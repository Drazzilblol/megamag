package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class InfoData {

    @NonNull
    public abstract String getText();

    @NonNull
    public static InfoData create(String text) {
        return new AutoValue_InfoData(text);
    }
}
