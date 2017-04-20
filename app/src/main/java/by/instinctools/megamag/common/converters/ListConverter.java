package by.instinctools.megamag.common.converters;

import android.support.annotation.NonNull;

import java.util.List;

public interface ListConverter<IN, OUT> {

    @NonNull
    List<OUT> convert(@NonNull List<IN> inList);
}
