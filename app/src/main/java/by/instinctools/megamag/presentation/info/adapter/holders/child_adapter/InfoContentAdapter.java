package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

import android.support.annotation.NonNull;
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
        int size = items.size();
        int currentSize = this.items.size();

        if (currentSize == 0) {
            this.items.addAll(items);
            notifyItemRangeInserted(0, size - 1);
        }

        Iterator<InfoItem> iterator = this.items.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            InfoItem item = iterator.next();
            int result = compare(items, item);
            if (result == -1) {
                iterator.remove();
                notifyItemRemoved(i);
                i--;
            }
            i++;
        }

        iterator = items.iterator();
        i = 0;
        while (iterator.hasNext()) {
            InfoItem item = iterator.next();
            int result = compare(this.items, item);
            if (result == -1) {
                this.items.add(i, item);
                notifyItemInserted(i);
                i++;
            }
            i++;
        }

        for (int j = 0; j < this.items.size(); j++) {
            InfoItem oldAnnouncement = this.items.get(j);
            InfoItem newAnnouncement = items.get(j);
            if (!oldAnnouncement.equals(newAnnouncement)) {
                this.items.set(j, newAnnouncement);
                notifyItemChanged(j);
            }
        }
    }

    private int compare(@NonNull List<InfoItem> items, InfoItem item) {
        int res = -1;
        for (int i = 0; i < items.size(); i++) {
            if (TextUtils.equals(item.getData(), items.get(i).getData())) {
                res = i;
            }
        }
        return res;
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
