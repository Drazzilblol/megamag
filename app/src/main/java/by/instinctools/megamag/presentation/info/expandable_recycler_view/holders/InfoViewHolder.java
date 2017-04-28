package by.instinctools.megamag.presentation.info.expandable_recycler_view.holders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class InfoViewHolder extends TreeViewBinder.ViewHolder {

    @BindView(R.id.info_text_view)
    TextView textView;

    public InfoViewHolder(View rootView) {
        super(rootView);
        ButterKnife.bind(this, itemView);
    }

    public TextView getTextView() {
        return textView;
    }
}