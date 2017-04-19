package by.instinctools.megamag.common.errors;

import android.support.annotation.NonNull;

public class ErrorException extends RuntimeException {

    @NonNull
    private final Error error;

    public ErrorException(@NonNull Error error) {
        this.error = error;
    }

    @NonNull
    public Error getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return error.getErrorMessage();
    }
}
