package by.instinctools.megamag.common.errors;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.utils.ImageUtils;

public class UnknownError extends BaseResourceError {

    public UnknownError() {
        super(R.string.unknown_error_message, ImageUtils.NO_URI_ID);
    }
}

