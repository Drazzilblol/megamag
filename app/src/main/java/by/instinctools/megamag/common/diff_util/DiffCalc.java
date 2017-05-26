package by.instinctools.megamag.common.diff_util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface DiffCalc<T, F> {

    @NonNull
    F convertConstraint(@Nullable CharSequence constraint);

    @Nullable
    CharSequence convertConstraint(@NonNull F filter);

    boolean checkForAll(@NonNull F constraint);

    boolean check(@NonNull F constraint, @NonNull T item);

    boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem);

    boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem);
}