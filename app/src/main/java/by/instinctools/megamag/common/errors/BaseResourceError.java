package by.instinctools.megamag.common.errors;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.common.utils.ImageUtils;

abstract class BaseResourceError extends BaseError {

    @NonNull
    private static Context context = Application.getAppContext();

    BaseResourceError(@StringRes int messageId, @DrawableRes int uriId) {
        super(context.getString(messageId), ImageUtils.getResourceUri(context, uriId));
    }

}
