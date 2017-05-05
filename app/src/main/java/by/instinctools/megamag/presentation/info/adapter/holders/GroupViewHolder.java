package by.instinctools.megamag.presentation.info.adapter.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class GroupViewHolder extends TreeViewBinder.ViewHolder {

    @BindView(R.id.group_title_view)
    TextView titleView;

    @BindView(R.id.group_image_view)
    ImageView imageView;

    public GroupViewHolder(View rootView) {
        super(rootView);
        ButterKnife.bind(this, itemView);
    }

    @NonNull
    public ImageView getImageView() {
        return imageView;
    }

    @NonNull
    public TextView getTitleView() {
        return titleView;
    }
}

