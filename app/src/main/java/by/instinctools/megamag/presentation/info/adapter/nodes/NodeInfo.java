package by.instinctools.megamag.presentation.info.adapter.nodes;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.R;
import by.instinctools.megamag.data.info.items.InfoItem;
import tellh.com.recyclertreeview_lib.LayoutItemType;

public class NodeInfo implements LayoutItemType {

    @NonNull
    private List<InfoItem> items;

    public NodeInfo(@NonNull List<InfoItem> items) {
        this.items = items;
    }

    @NonNull
    public List<InfoItem> getItems() {
        return items;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_info;
    }
}
