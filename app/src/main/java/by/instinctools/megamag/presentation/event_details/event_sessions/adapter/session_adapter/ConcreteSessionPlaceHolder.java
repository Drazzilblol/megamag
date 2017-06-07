package by.instinctools.megamag.presentation.event_details.event_sessions.adapter.session_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;

class ConcreteSessionPlaceHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.session_place)
    TextView placeTextView;

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.item_details_session_place, parent, false);
    }

    ConcreteSessionPlaceHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull String place) {
        placeTextView.setText(place);
    }
}
