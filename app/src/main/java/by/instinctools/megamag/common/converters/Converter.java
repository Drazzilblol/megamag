package by.instinctools.megamag.common.converters;

import android.support.annotation.NonNull;

public interface Converter<IN, OUT> {

    @NonNull
    OUT convert(@NonNull IN in);
}
