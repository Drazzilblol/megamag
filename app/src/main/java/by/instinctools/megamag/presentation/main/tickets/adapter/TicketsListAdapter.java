package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;

import by.instinctools.megamag.common.diff_util.BaseDiffAdapter;
import by.instinctools.megamag.domain.models.Ticket;

public class TicketsListAdapter extends BaseDiffAdapter<TicketHolder, Ticket> {

    @Override
    public TicketHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TicketHolder(parent);
    }

    @Override
    public void onBindViewHolder(TicketHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    @Override
    public boolean areItemsTheSame(@NonNull Ticket oldItem, @NonNull Ticket newItem) {
        return TextUtils.equals(oldItem.getTitle(), newItem.getTitle());
    }
}

