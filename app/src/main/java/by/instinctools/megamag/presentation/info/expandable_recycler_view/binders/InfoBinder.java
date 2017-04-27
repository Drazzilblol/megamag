package by.instinctools.megamag.presentation.info.expandable_recycler_view.binders;


import android.view.View;
import android.widget.TextView;

import by.instinctools.megamag.R;
import by.instinctools.megamag.domain.models.Info;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class InfoBinder extends TreeViewBinder<InfoBinder.ViewHolder> {

    @Override
    public InfoBinder.ViewHolder provideViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void bindView(InfoBinder.ViewHolder viewHolder, int i, TreeNode treeNode) {
        Info fileNode = (Info) treeNode.getContent();
        viewHolder.tvName.setText(fileNode.getText());
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_info;
    }

    public class ViewHolder extends TreeViewBinder.ViewHolder {
        public TextView tvName;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}
