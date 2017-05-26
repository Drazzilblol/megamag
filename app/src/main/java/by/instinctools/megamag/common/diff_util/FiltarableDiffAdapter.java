package by.instinctools.megamag.common.diff_util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public abstract class FiltarableDiffAdapter<VH extends RecyclerView.ViewHolder, T, F> extends RecyclerView.Adapter<VH> implements Filterable, DiffCalc<T, F> {

    @NonNull
    private final List<T> original = new ArrayList<>();

    @NonNull
    private final List<T> items = new ArrayList<>();

    @NonNull
    private final SimpleDiffFilter<T, F> filter = new SimpleDiffFilter<>(this, this);

    @NonNull
    private F lastFilter = getInitialFilter();

    @NonNull
    protected abstract F getInitialFilter();

    @NonNull
    public F getLastFilter() {
        return lastFilter;
    }

    @NonNull
    List<T> getOriginalItems() {
        return original;
    }

    @NonNull
    List<T> getFilteredItems() {
        return items;
    }

    void setFilteredItems(@NonNull List<T> filtered) {
        items.clear();
        if (!filtered.isEmpty()) {
            items.addAll(filtered);
        }
    }

    public void changeItems(@NonNull List<T> items) {
        this.original.clear();
        if (items.isEmpty()) {
            this.original.addAll(items);
        }
        filter(lastFilter);
    }

    public void addItems(@NonNull List<T> items) {
        boolean smthAdded = false;
        for (T item : items) {
            if (!original.contains(item)) {
                smthAdded = true;
                original.add(item);
            }
        }
        if (smthAdded) {
            filter(lastFilter);
        }
    }

    public void addItem(@NonNull T item) {
        if (!original.contains(item)) {
            original.add(item);
            filter(lastFilter);
        }
    }

    public void removeItem(@NonNull T item) {
        int index = original.indexOf(item);
        if (index >= 0) {
            original.remove(index);
            filter(lastFilter);
        }
    }

    @NonNull
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filter(@NonNull F filter) {
        lastFilter = filter;
        getFilter().filter(convertConstraint(filter));
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    @Override
    public boolean checkForAll(@NonNull F constraint) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.equals(newItem);
    }
}