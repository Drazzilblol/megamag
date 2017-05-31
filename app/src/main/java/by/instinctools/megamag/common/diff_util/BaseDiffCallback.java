package by.instinctools.megamag.common.diff_util;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import java.util.List;

public abstract class BaseDiffCallback<T> extends DiffUtil.Callback {

    @NonNull
    private final List<T> oldList;

    @NonNull
    private final List<T> newList;

    protected BaseDiffCallback(@NonNull List<T> oldList, @NonNull List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public final int getOldListSize() {
        return oldList.size();
    }

    @Override
    public final int getNewListSize() {
        return newList.size();
    }

    @Override
    public final boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        T oldT = oldList.get(oldItemPosition);
        T newT = newList.get(newItemPosition);
        if (oldT == null || newT == null) {
            throw new IllegalArgumentException("Cant handle lists with null items");
        }
        return areItemsTheSame(oldT, newT);
    }

    protected abstract boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem);

    @Override
    public final boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        T oldT = oldList.get(oldItemPosition);
        T newT = newList.get(newItemPosition);
        if (oldT == null || newT == null) {
            throw new IllegalArgumentException("Cant handle lists with null items");
        }
        return areContentsTheSame(oldT, newT);
    }

    protected boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.equals(newItem);
    }
}