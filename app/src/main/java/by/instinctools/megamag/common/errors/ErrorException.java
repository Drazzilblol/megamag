package by.instinctools.megamag.common.errors;

public class ErrorException extends RuntimeException {

    private final Error ERROR;

    public ErrorException(Error error){
        this.ERROR = error;
    }

    public Error getError() {
        return ERROR;
    }
}
