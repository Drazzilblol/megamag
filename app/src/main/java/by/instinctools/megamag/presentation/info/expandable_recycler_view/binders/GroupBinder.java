package by.instinctools.megamag.presentation.info.expandable_recycler_view.binders;


import android.view.View;

import by.instinctools.megamag.R;
import by.instinctools.megamag.presentation.info.expandable_recycler_view.holders.GroupViewHolder;
import by.instinctools.megamag.presentation.info.expandable_recycler_view.nodes.NodeGroup;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class GroupBinder extends TreeViewBinder<GroupViewHolder> {

    @Override
    public GroupViewHolder provideViewHolder(View view) {
        return new GroupViewHolder(view);
    }

    @Override
    public void bindView(GroupViewHolder groupViewHolder, int i, TreeNode treeNode) {
        NodeGroup nodeGroup = (NodeGroup) treeNode.getContent();
        groupViewHolder.getTitleView().setText(nodeGroup.getTitle());
        groupViewHolder.getImageView().setImageResource(R.drawable.ic_add_black_24dp);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_group;
    }
}