package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
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
            notifyItemRangeInserted(0, size - 1);
        }

        Iterator<Ticket> iterator = this.tickets.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            Ticket item = iterator.next();
            int result = compare(tickets, item);
            if (result == -1) {
                iterator.remove();
                notifyItemRemoved(i);
                i--;
            }
            i++;
        }

        iterator = tickets.iterator();
        i = 0;
        while (iterator.hasNext()) {
            Ticket item = iterator.next();
            int result = compare(this.tickets, item);
            if (result == -1) {
                this.tickets.add(i, item);
                notifyItemInserted(i);
                i++;
            }
            i++;
        }

        for (int j = 0; j < this.tickets.size(); j++) {
            Ticket oldAnnouncement = this.tickets.get(j);
            Ticket newAnnouncement = tickets.get(j);
            if (!oldAnnouncement.equals(newAnnouncement)) {
                this.tickets.set(j, newAnnouncement);
                notifyItemChanged(j);
            }
        }
    }

    private int compare(@NonNull List<Ticket> tickets, Ticket item) {
        int res = -1;
        for (int i = 0; i < tickets.size(); i++) {
            if (TextUtils.equals(item.getTitle(), tickets.get(i).getTitle())) {
                res = i;
            }
        }
        return res;
    }
}

