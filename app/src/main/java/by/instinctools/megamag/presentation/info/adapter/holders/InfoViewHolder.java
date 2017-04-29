package by.instinctools.megamag.presentation.info.adapter.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class InfoViewHolder extends TreeViewBinder.ViewHolder {

    @BindView(R.id.item_info_recycler_view)
    RecyclerView recyclerView;

    public InfoViewHolder(View rootView) {
        super(rootView);
        ButterKnife.bind(this, itemView);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}