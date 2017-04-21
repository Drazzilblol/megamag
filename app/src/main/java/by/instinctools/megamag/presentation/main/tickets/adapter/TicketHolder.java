package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.domain.models.Ticket;

public class TicketHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ticket_title_view)
    TextView titleTextView;

    @BindView(R.id.ticket_begin_with_view)
    TextView beginWithTextView;

    @BindView(R.id.ticket_cover)
    ImageView imageView;

    private static View getView(@NonNull ViewGroup parent) {
        return LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ticket, parent, false);
    }

    public TicketHolder(@NonNull ViewGroup parent) {
        super(getView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull Ticket ticket) {
        titleTextView.setText(ticket.getTitle());
        beginWithTextView.setText(ticket.getBeginsWith());
        Picasso.with(Application.getAppContext())
                .load(ticket.getCoverUri())
                .into(imageView);
    }


}
