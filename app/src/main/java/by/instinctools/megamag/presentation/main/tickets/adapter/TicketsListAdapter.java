package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.domain.models.TicketViewModel;

public class TicketsListAdapter extends RecyclerView.Adapter<TicketHolder> {

    @NonNull
    private final List<TicketViewModel> tickets = new ArrayList<>();

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

    public void setTickets(@NonNull List<TicketViewModel> tickets) {
        this.tickets.clear();
        this.tickets.addAll(tickets);
        notifyDataSetChanged();
    }

}
