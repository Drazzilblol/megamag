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
import by.instinctools.megamag.presentation.main.callbacks.OnItemClickListener;

class TicketHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.ticket_title_view)
    TextView titleTextView;

    @BindView(R.id.ticket_begin_with_view)
    TextView beginWithTextView;

    @BindView(R.id.ticket_cover)
    ImageView imageView;

    @NonNull
    private OnItemClickListener listener;

    private Ticket ticket;

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return layoutInflater.inflate(R.layout.item_ticket, parent, false);
    }

    TicketHolder(@NonNull ViewGroup parent, @NonNull OnItemClickListener listener) {
        super(inflateView(parent));
        this.listener = listener;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    void bindData(@NonNull Ticket ticket) {
        this.ticket = ticket;
        titleTextView.setText(ticket.getTitle());
        beginWithTextView.setText(ticket.getBeginsWith());
        ImageUtils.loadImageWithBlur(
                itemView.getContext(),
                imageView,
                ticket.getCoverUrl(),
                ticket.getCoverUrlLQ()
        );
    }

    @Override
    public void onClick(View v) {
        listener.onClick(ticket.getEventId());
    }
}
