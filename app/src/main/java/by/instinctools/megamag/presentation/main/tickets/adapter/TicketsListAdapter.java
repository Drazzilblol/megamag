package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.domain.models.Ticket;

public class TicketsListAdapter extends RecyclerView.Adapter<TicketHolder> {

    @NonNull
    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public TicketHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TicketHolder(parent);
    }

    @Override
    public void onBindViewHolder(TicketHolder holder, int position) {
        holder.bindData(tickets.get(position));
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public void setTickets(@NonNull List<Ticket> tickets) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new TicketDiffCallback(this.tickets, tickets));
        this.tickets.clear();
        this.tickets.addAll(tickets);
        diffResult.dispatchUpdatesTo(this);
    }
}

