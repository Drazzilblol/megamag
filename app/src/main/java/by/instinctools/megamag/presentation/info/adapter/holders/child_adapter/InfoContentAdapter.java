package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
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
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new InfoContentDiffCallback(this.items, items));
        this.items.clear();
        this.items.addAll(items);
        diffResult.dispatchUpdatesTo(this);
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
