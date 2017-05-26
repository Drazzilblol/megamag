package by.instinctools.megamag.common.diff_util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

public class SimpleDiffFilter<T, F> extends BaseDiffFilter<T, F> {

    @NonNull
    private final FiltarableDiffAdapter<?, T, F> adapter;

    @NonNull
    private final DiffCalc<T, F> calc;

    public SimpleDiffFilter(@NonNull FiltarableDiffAdapter<?, T, F> adapter, @NonNull DiffCalc<T, F> calc) {
        super(adapter);
        this.adapter = adapter;
        this.calc = calc;
    }

    @NonNull
    @Override
    protected F convertConstraint(@Nullable CharSequence constraint) {
        return calc.convertConstraint(constraint);
    }

    @Override
    protected boolean checkForAll(@NonNull F constraint) {
        return calc.checkForAll(constraint);
    }

    @Override
    protected boolean check(@NonNull F constraint, @NonNull T item) {
        return calc.check(constraint, item);
    }

    @NonNull
    @Override
    protected List<T> getOriginalItems() {
        return adapter.getOriginalItems();
    }

    @NonNull
    @Override
    protected List<T> getFilteredItems() {
        return adapter.getFilteredItems();
    }

    @Override
    protected void setFilteredItems(@NonNull List<T> filtered) {
        adapter.setFilteredItems(filtered);
    }

    @NonNull
    @Override
    protected DiffUtil.Callback getDiffCallback(@NonNull List<T> oldList, @NonNull List<T> newList) {
        return new InnerDiffCallback(oldList, newList);
    }

    private final class InnerDiffCallback extends BaseDiffCallback<T> {

        InnerDiffCallback(@NonNull List<T> oldList, @NonNull List<T> newList) {
            super(oldList, newList);
        }

        @Override
        protected boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
            return calc.areItemsTheSame(oldItem, newItem);
        }

        @Override
        protected boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
            return calc.areContentsTheSame(oldItem, newItem);
        }
    }
}