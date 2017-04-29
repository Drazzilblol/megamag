package by.instinctools.megamag.data.info.items;

import android.support.annotation.NonNull;

public class InfoImage implements InfoItem {

    private String imageUrl;

    public InfoImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public String getData() {
        return imageUrl;
    }
}
