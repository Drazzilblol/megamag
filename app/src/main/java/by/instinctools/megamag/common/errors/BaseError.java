package by.instinctools.megamag.common.errors;


import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

abstract class BaseError implements Error {

    @NonNull
    private final String errorMessage;

    @Nullable
    private final Uri errorUri;

    BaseError(@NonNull String message, @Nullable Uri uri) {
        errorMessage = message;
        errorUri = uri;
    }

    @Nullable
    @Override
    public Uri getUri() {
        return errorUri;
    }

    @NonNull
    public String getErrorMessage() {
        return errorMessage;
    }
}
