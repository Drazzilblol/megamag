package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.data.info.items.InfoImage;
import by.instinctools.megamag.data.info.items.InfoItem;
import by.instinctools.megamag.data.info.items.InfoText;

public class InfoContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_TEXT = 0;
    private static final int TYPE_IMAGE = 1;

    @NonNull
    private final List<InfoItem> items = new ArrayList<>();

    public InfoContentAdapter(List<InfoItem> items) {
        setItems(items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TEXT) {
            return new InfoTextViewHolder(parent);
        }
        if (viewType == TYPE_IMAGE) {
            return new InfoImageViewHolder(parent);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof InfoTextViewHolder) {
            ((InfoTextViewHolder) holder).bindData((InfoText) items.get(position));
        }
        if (holder instanceof InfoImageViewHolder) {
            ((InfoImageViewHolder) holder).bindData((InfoImage) items.get(position));
        }
    }

    public void setItems(@NonNull List<InfoItem> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof InfoText) {
            return TYPE_TEXT;
        } else {
            return TYPE_IMAGE;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
