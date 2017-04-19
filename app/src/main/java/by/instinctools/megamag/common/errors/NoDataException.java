package by.instinctools.megamag.common.errors;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.utils.DrawableUtils;

public class NoDataException extends BaseResourceError {

    public NoDataException() {
        super(R.string.no_data_exception_message, DrawableUtils.NO_URI_ID);
    }
}
