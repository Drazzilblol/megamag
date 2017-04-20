package by.instinctools.megamag.common.converters;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConverter<IN, OUT> implements ListConverter<IN, OUT>, Converter<IN, OUT> {

    @NonNull
    @Override
    public List<OUT> convert(@NonNull List<IN> inList) {
        List<OUT> outList = new ArrayList<>();
        for (IN in : inList) {
            outList.add(convert(in));
        }
        return outList;
    }
}
