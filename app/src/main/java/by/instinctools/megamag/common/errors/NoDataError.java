package by.instinctools.megamag.common.errors;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.utils.ImageUtils;

public class NoDataError extends BaseResourceError {

    public NoDataError() {
        super(R.string.no_data_exception_message, ImageUtils.NO_URI_ID);
    }
}
