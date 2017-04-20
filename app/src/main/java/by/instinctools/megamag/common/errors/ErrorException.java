package by.instinctools.megamag.common.errors;

public class ErrorException extends RuntimeException {

    private final Error error;

    public ErrorException(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
