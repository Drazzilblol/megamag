package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.support.annotation.NonNull;
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
        int size = tickets.size();
        int currentSize = this.tickets.size();

        if (currentSize > size) {
            this.tickets.subList(size, currentSize).clear();
            notifyItemRangeRemoved(size, currentSize);
        }

        for (int i = 0; i < size; i++) {
            if (this.tickets.size() <= i) {
                this.tickets.add(tickets.get(i));
                notifyItemInserted(i);
            } else if (!this.tickets.get(i).equals(tickets.get(i))) {
                this.tickets.set(i, tickets.get(i));
                notifyItemChanged(i);
            }
        }
    }
}
