package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.data.info.items.InfoImage;
import by.instinctools.megamag.data.info.items.InfoItem;
import by.instinctools.megamag.data.info.items.InfoText;

public class InfoContentAdapter extends RecyclerView.Adapter<InfoViewHolder> {

    private static final int TYPE_TEXT = 0;
    private static final int TYPE_IMAGE = 1;

    @NonNull
    private final List<InfoItem> items = new ArrayList<>();

    public InfoContentAdapter(List<InfoItem> items) {
        setItems(items);
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TEXT) {
            return new InfoTextViewHolder(parent);
        }
        if (viewType == TYPE_IMAGE) {
            return new InfoImageViewHolder(parent);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    public void setItems(@NonNull List<InfoItem> items) {
        int size = items.size();
        int currentSize = this.items.size();

        if (currentSize == 0) {
            this.items.addAll(items);
            notifyDataSetChanged();
        }

        if (currentSize > size) {
            for (int i = 0; i < currentSize; i++) {
                InfoItem item = this.items.get(i);
                int itemIndex = items.indexOf(item);
                if (itemIndex == -1 && currentSize > size) {
                    this.items.remove(i);
                    notifyItemRemoved(i);
                    currentSize = this.items.size();
                }
            }
        }

        if (currentSize < size) {
            for (int i = 0; i < size; i++) {
                InfoItem item = items.get(i);
                int itemIndex = this.items.indexOf(item);
                if (itemIndex == -1 && currentSize < size) {
                    this.items.add(i, item);
                    notifyItemInserted(i);
                    currentSize = this.items.size();
                }
            }
        }

        if (currentSize == size) {
            for (int i = 0; i < size; i++) {
                InfoItem item = items.get(i);
                int itemIndex = this.items.indexOf(item);
                if (itemIndex == -1) {
                    this.items.set(i, item);
                    notifyItemChanged(i);
                }
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        InfoItem item = items.get(position);
        if (item instanceof InfoText) {
            return TYPE_TEXT;
        } else if (item instanceof InfoImage) {
            return TYPE_IMAGE;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
