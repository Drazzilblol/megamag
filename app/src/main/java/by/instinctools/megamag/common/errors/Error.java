package by.instinctools.megamag.common.errors;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface Error {

    @NonNull
    String getErrorMessage();

    @Nullable
    Uri getUri();
}
