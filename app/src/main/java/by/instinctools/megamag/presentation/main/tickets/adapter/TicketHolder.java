package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.domain.models.TicketViewModel;

public class TicketHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ticket_title_view)
    TextView titleTextView;

    @BindView(R.id.ticket_begin_with_view)
    TextView beginWithTextView;

    @BindView(R.id.ticket_cover)
    ImageView imageView;

    private static View getView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ticket_item, parent, false);
    }

    public TicketHolder(@NonNull ViewGroup parent) {
        super(getView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull TicketViewModel ticket) {
        titleTextView.setText(ticket.getTitle());
        beginWithTextView.setText(ticket.getBeginsWith());
    }


}
