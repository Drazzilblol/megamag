package by.instinctools.megamag.common.errors;


import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

abstract class BaseError implements Error {

    @NonNull
    private final String ERROR_MESSAGE;

    @Nullable
    private final Uri ERROR_URI;

    BaseError(@NonNull String message, @Nullable Uri uri) {
        ERROR_MESSAGE = message;
        ERROR_URI = uri;
    }

    @Nullable
    @Override
    public Uri getUri() {
        return ERROR_URI;
    }

    @NonNull
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
