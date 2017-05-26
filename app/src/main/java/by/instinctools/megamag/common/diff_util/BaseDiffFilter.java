package by.instinctools.megamag.common.diff_util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDiffFilter<T, F> extends Filter {
    @NonNull
    private final RecyclerView.Adapter adapter;

    protected BaseDiffFilter(@NonNull RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    @NonNull
    protected abstract F convertConstraint(@Nullable CharSequence constraint);

    protected boolean checkForAll(@NonNull F constraint) {
        return false;
    }

    protected abstract boolean check(@NonNull F constraint, @NonNull T item);

    @NonNull
    protected abstract List<T> getOriginalItems();

    @NonNull
    protected abstract List<T> getFilteredItems();

    protected abstract void setFilteredItems(@NonNull List<T> filtered);

    @NonNull
    protected abstract DiffUtil.Callback getDiffCallback(@NonNull List<T> oldList, @NonNull List<T> newList);

    @Override
    protected final FilterResults performFiltering(CharSequence constraint) {
        final List<T> original = getOriginalItems();
        final List<T> previous = getFilteredItems();
        final List<T> filtered = new ArrayList<>(original.size());

        F filter = convertConstraint(constraint);
        if (checkForAll(filter)) {
            filtered.addAll(original);
        } else {
            for (T item : original) {
                if (check(filter, item)) {
                    filtered.add(item);
                }
            }
        }

        DiffUtil.Callback diffCallback = getDiffCallback(previous, filtered);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        final FilterResults results = new FilterResults();
        results.values = Pair.create(filtered, diffResult);
        results.count = filtered.size();
        return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void publishResults(CharSequence constraint, FilterResults results) {
        Pair<List<T>, DiffUtil.DiffResult> pair = (Pair<List<T>, DiffUtil.DiffResult>) results.values;
        setFilteredItems(pair.first);
        pair.second.dispatchUpdatesTo(adapter);
    }
}