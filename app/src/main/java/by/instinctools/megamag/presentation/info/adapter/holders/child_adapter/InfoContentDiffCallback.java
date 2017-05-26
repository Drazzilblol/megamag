package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.text.TextUtils;

import java.util.List;

import by.instinctools.megamag.data.info.items.InfoItem;

class InfoContentDiffCallback extends DiffUtil.Callback {

    @NonNull
    private List<InfoItem> oldList;

    @NonNull
    private List<InfoItem> newList;

    InfoContentDiffCallback(@NonNull List<InfoItem> oldList, @NonNull List<InfoItem> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return TextUtils.equals(oldList.get(oldItemPosition).getData(), newList.get(newItemPosition).getData());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
