package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;

import java.util.List;

import by.instinctools.megamag.common.diff_util.BaseDiffAdapter;
import by.instinctools.megamag.data.info.items.InfoImage;
import by.instinctools.megamag.data.info.items.InfoItem;
import by.instinctools.megamag.data.info.items.InfoText;

public class InfoContentAdapter extends BaseDiffAdapter<InfoViewHolder, InfoItem> {

    private static final int TYPE_TEXT = 0;
    private static final int TYPE_IMAGE = 1;

    public InfoContentAdapter(List<InfoItem> items) {
        changeItems(items);
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
        holder.bind(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        InfoItem item = getItem(position);
        if (item instanceof InfoText) {
            return TYPE_TEXT;
        } else if (item instanceof InfoImage) {
            return TYPE_IMAGE;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean areItemsTheSame(@NonNull InfoItem oldItem, @NonNull InfoItem newItem) {
        return TextUtils.equals(oldItem.getData(), newItem.getData());
    }
}
