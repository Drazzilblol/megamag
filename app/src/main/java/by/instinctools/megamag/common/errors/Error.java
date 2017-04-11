package by.instinctools.megamag.common.errors;

import android.support.annotation.NonNull;

import java.net.URI;

public interface Error {

    @NonNull
    String getMessage();

    @NonNull
    URI getUri();
}
