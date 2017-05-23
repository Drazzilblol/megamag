package by.instinctools.megamag.common.errors;

import by.instinctools.megamag.R;
import by.instinctools.megamag.common.utils.ImageUtils;

public class NoIdError extends BaseResourceError {

    public NoIdError() {
        super(R.string.no_id_error_message, ImageUtils.NO_URI_ID);
    }
}
