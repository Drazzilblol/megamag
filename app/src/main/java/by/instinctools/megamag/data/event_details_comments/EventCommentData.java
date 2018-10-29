package by.instinctools.megamag.data.event_details_comments;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventCommentData {

    @NonNull
    public abstract String getUserName();

    @NonNull
    public abstract String getText();

    @NonNull
    public abstract String getAvatarUrl();

    @NonNull
    public static EventCommentData.Builder builder() {
        return new AutoValue_EventCommentData.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract EventCommentData.Builder userName(@NonNull String value);

        public abstract EventCommentData.Builder text(@NonNull String value);

        public abstract EventCommentData.Builder avatarUrl(@NonNull String value);

        public abstract EventCommentData build();
    }
}
