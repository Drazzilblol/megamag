package by.instinctools.megamag.presentation.info.adapter.nodes;

import android.support.annotation.NonNull;

import by.instinctools.megamag.R;
import tellh.com.recyclertreeview_lib.LayoutItemType;

public class NodeInfo implements LayoutItemType {

    @NonNull
    private String text;

    public NodeInfo(@NonNull String text) {
        this.text = text;
    }

    @NonNull
    public String getText() {
        return text;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_info;
    }
}
