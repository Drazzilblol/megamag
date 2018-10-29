package by.instinctools.megamag.presentation.event_details.event_sessions.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.utils.TimeUtils;

class ConcreteSessionTimeHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.session_date)
    TextView timeTextView;

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.item_details_session_time, parent, false);
    }

    ConcreteSessionTimeHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull String time, @NonNull String day) {
        timeTextView.setText(time);
        if (TimeUtils.isSessionBegin(time, day)) {
            timeTextView.setPaintFlags(timeTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
