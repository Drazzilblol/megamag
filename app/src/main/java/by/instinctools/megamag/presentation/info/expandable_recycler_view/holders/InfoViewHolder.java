package by.instinctools.megamag.presentation.info.expandable_recycler_view.holders;

import android.view.View;
import android.widget.TextView;

import by.instinctools.megamag.R;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class InfoViewHolder extends TreeViewBinder.ViewHolder {

    public TextView textView;

    public InfoViewHolder(View rootView) {
        super(rootView);
        this.textView = (TextView) rootView.findViewById(R.id.tv_name);
    }

}