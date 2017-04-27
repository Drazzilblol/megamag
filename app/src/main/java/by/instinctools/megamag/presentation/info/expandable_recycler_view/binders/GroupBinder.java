package by.instinctools.megamag.presentation.info.expandable_recycler_view.binders;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.domain.models.Group;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class GroupBinder extends TreeViewBinder<GroupBinder.ViewHolder> {

    @Override
    public ViewHolder provideViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void bindView(ViewHolder viewHolder, int i, TreeNode treeNode) {
        Group group = (Group) treeNode.getContent();
        viewHolder.titleView.setText(group.getTitle());

        viewHolder.imageView.setImageResource(R.drawable.ic_add_black_24dp);
        if (treeNode.isLeaf())
            viewHolder.imageView.setVisibility(View.INVISIBLE);
        else viewHolder.imageView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_group;
    }

    public static class ViewHolder extends TreeViewBinder.ViewHolder {

        @BindView(R.id.group_title_view)
        TextView titleView;

        @BindView(R.id.group_image_view)
        ImageView imageView;

        public ViewHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this, itemView);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }
}
