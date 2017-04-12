package by.instinctools.megamag.common.errors;

import by.instinctools.megamag.R;

public class NoDataException extends BaseResourceError {
    public NoDataException() {
        super(R.string.no_data_exception_message, 0);
    }
}
