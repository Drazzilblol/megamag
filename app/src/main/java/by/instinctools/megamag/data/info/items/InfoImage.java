package by.instinctools.megamag.data.info.items;

import android.support.annotation.NonNull;

public class InfoImage implements InfoItem {

    @NonNull
    private String imageUrl;

    public InfoImage(@NonNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public String getData() {
        return imageUrl;
    }
}
