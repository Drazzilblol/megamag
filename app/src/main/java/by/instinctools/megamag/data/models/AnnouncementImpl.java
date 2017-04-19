package by.instinctools.megamag.data.models;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AnnouncementImpl implements Announcement {

    public static Announcement create(String details, String description){
        return new AutoValue_AnnouncementImpl(details, description);
    }
}
