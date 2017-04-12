package by.instinctools.megamag.common.errors;


import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

abstract class BaseError extends RuntimeException implements Error {

    @NonNull
    private String errorMessage;

    @Nullable
    private Uri errorUri;

    protected BaseError(@NonNull String message, @Nullable Uri uri) {
        errorMessage = message;
        errorUri = uri;
    }

    @Nullable
    @Override
    public Uri getUri() {
        return errorUri;
    }

    @NonNull
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
