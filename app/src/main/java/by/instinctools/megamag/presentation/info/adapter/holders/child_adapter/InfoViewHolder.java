package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import by.instinctools.megamag.data.info.items.InfoItem;

public abstract class InfoViewHolder extends RecyclerView.ViewHolder {

    InfoViewHolder(View itemView) {
        super(itemView);
    }

    abstract void bind(@NonNull InfoItem item);
}
