package by.instinctools.megamag.common.diff_util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

public abstract class BaseDiffAdapter<VH extends RecyclerView.ViewHolder, T> extends FiltarableDiffAdapter<VH, T, CharSequence> {

    private static final String EMPTY = "";

    @NonNull
    @Override
    protected CharSequence getInitialFilter() {
        return EMPTY;
    }

    @Override
    public boolean checkForAll(@NonNull CharSequence constraint) {
        return true;
    }

    @Override
    public boolean check(@NonNull CharSequence constraint, @NonNull T item) {
        return true;
    }

    @NonNull
    @Override
    public CharSequence convertConstraint(@Nullable CharSequence constraint) {
        return TextUtils.isEmpty(constraint) ? EMPTY : constraint;
    }
}