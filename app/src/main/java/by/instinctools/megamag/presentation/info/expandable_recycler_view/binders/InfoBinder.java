package by.instinctools.megamag.presentation.info.expandable_recycler_view.binders;


import android.view.View;

import by.instinctools.megamag.R;
import by.instinctools.megamag.presentation.info.expandable_recycler_view.holders.InfoViewHolder;
import by.instinctools.megamag.presentation.info.expandable_recycler_view.nodes.NodeInfo;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class InfoBinder extends TreeViewBinder<InfoViewHolder> {

    @Override
    public InfoViewHolder provideViewHolder(View view) {
        return new InfoViewHolder(view);
    }

    @Override
    public void bindView(InfoViewHolder infoViewHolder, int i, TreeNode treeNode) {
        NodeInfo fileNode = (NodeInfo) treeNode.getContent();
        infoViewHolder.getTextView().setText(fileNode.getText());
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_info;
    }

}
