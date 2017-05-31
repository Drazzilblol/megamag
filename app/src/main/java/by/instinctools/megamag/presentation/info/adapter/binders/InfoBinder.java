package by.instinctools.megamag.presentation.info.adapter.binders;


import android.view.View;

import by.instinctools.megamag.R;
import by.instinctools.megamag.presentation.info.adapter.holders.InfoViewHolder;
import by.instinctools.megamag.presentation.info.adapter.holders.child_adapter.InfoContentAdapter;
import by.instinctools.megamag.presentation.info.adapter.nodes.NodeInfo;
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

        InfoContentAdapter infoContentAdapter = (InfoContentAdapter) infoViewHolder.getRecyclerView().getAdapter();
        if (infoContentAdapter == null) {
            InfoContentAdapter adapter = new InfoContentAdapter(fileNode.getItems());
            infoViewHolder.getRecyclerView().setAdapter(adapter);
        } else {
            infoContentAdapter.changeItems(fileNode.getItems());
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_info;
    }
}
