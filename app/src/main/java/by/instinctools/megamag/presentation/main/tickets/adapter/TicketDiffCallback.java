package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.text.TextUtils;

import java.util.List;

import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.domain.models.Ticket;

class TicketDiffCallback extends DiffUtil.Callback {

    @NonNull
    private List<Ticket> oldList;

    @NonNull
    private List<Ticket> newList;

    TicketDiffCallback(@NonNull List<Ticket> oldList, @NonNull List<Ticket> newList) {
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
        return TextUtils.equals(oldList.get(oldItemPosition).getTitle(), newList.get(newItemPosition).getTitle());
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
