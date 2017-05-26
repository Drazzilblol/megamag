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

        if (currentSize == 0) {
            this.tickets.addAll(tickets);
            notifyDataSetChanged();
        }

        if (currentSize > size) {
            for (int i = 0; i < currentSize; i++) {
                Ticket item = this.tickets.get(i);
                int itemIndex = tickets.indexOf(item);
                if (itemIndex == -1 && currentSize > size) {
                    this.tickets.remove(i);
                    notifyItemRemoved(i);
                    currentSize = this.tickets.size();
                }
            }
        }

        if (currentSize < size) {
            for (int i = 0; i < size; i++) {
                Ticket item = tickets.get(i);
                int itemIndex = this.tickets.indexOf(item);
                if (itemIndex == -1 && currentSize < size) {
                    this.tickets.add(i, item);
                    notifyItemInserted(i);
                    currentSize = this.tickets.size();
                }
            }
        }

        if (currentSize == size) {
            for (int i = 0; i < size; i++) {
                Ticket item = tickets.get(i);
                int itemIndex = this.tickets.indexOf(item);
                if (itemIndex == -1) {
                    this.tickets.set(i, item);
                    notifyItemChanged(i);
                }
            }
        }
    }
}
