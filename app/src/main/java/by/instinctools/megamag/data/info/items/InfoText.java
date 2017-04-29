package by.instinctools.megamag.data.info.items;

import android.support.annotation.NonNull;

public class InfoText implements InfoItem {

    private String text;

    public InfoText(String text) {
        this.text = text;
    }

    @NonNull
    @Override
    public String getData() {
        return text;
    }
}
