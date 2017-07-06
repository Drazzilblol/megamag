package by.instinctools.megamag.presentation.event_details.event_sessions.adapter.session_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.domain.models.EventSession;
import timber.log.Timber;

class ConcreteSessionDateHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.session_date)
    TextView dateTextView;

    @BindView(R.id.item_session_layout)
    LinearLayout layout;

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.item_details_session_date, parent, false);
    }

    ConcreteSessionDateHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull List<EventSession> list) {
        dateTextView.setText(list.get(0).getDay());

        LinearLayout linearLayout = new LinearLayout(itemView.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < list.size(); i++) {
            EventSession session = list.get(i);
            float f = (float) i % 2;
            if (f == 0.0f) {
                layout.addView(linearLayout);
                linearLayout = new LinearLayout(itemView.getContext());
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            }
            CardView card = new CardView(itemView.getContext());
            TableRow.LayoutParams params = new TableRow.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT, 1.0f);
            params.setMargins(8, 8, 8, 8);
            card.setLayoutParams(params);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Timber.i(session.getSessionId());
                }
            });

            TextView textView = new TextView(itemView.getContext());
            textView.setGravity(Gravity.CENTER);
            textView.setText(session.getTime());
            textView.setPadding(8, 32, 8, 32);

            card.addView(textView);

            linearLayout.addView(card);
        }

        layout.addView(linearLayout);
    }
}
