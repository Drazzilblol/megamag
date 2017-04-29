package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

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
import by.instinctools.megamag.data.info.items.InfoText;

public class InfoTextViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_info_text_view)
    TextView textView;

    public InfoTextViewHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
    }

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return layoutInflater.inflate(R.layout.item_info_text, parent, false);
    }

    void bindData(@NonNull InfoText infoText) {
        textView.setText(infoText.getData());
    }

}
