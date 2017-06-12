package by.instinctools.megamag.presentation.main.tickets.adapter;

import android.content.Context;
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
import by.instinctools.megamag.common.utils.ImageUtils;
import by.instinctools.megamag.domain.models.Ticket;

class TicketHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ticket_title_view)
    TextView titleTextView;

    @BindView(R.id.ticket_begin_with_view)
    TextView beginWithTextView;

    @BindView(R.id.ticket_cover)
    ImageView imageView;

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return layoutInflater.inflate(R.layout.item_ticket, parent, false);
    }

    TicketHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull Ticket ticket) {
        titleTextView.setText(ticket.getTitle());
        beginWithTextView.setText(ticket.getBeginsWith());
        ImageUtils.loadImageWithBlur(
                itemView.getContext(),
                imageView,
                ticket.getCoverUrl(),
                ticket.getCoverUrlLQ()
        );
    }
}
