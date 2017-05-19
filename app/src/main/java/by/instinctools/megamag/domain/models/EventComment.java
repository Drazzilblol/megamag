package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventComment {
    @NonNull
    public abstract String getUserName();

    @NonNull
    public abstract String getText();

    @NonNull
    public abstract String getAvatarUrl();

    @NonNull
    public static EventComment.Builder builder() {
        return new AutoValue_EventComment.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract EventComment.Builder userName(@NonNull String value);

        public abstract EventComment.Builder text(@NonNull String value);

        public abstract EventComment.Builder avatarUrl(@NonNull String value);

        public abstract EventComment build();
    }
}
