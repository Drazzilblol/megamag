package by.instinctools.megamag.presentation.info.expandable_recycler_view.nodes;

import android.support.annotation.NonNull;

import by.instinctools.megamag.R;
import tellh.com.recyclertreeview_lib.LayoutItemType;

public class NodeGroup implements LayoutItemType {

    @NonNull
    private String title;

    public NodeGroup(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_group;
    }

}
