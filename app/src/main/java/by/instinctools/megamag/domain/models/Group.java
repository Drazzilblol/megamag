package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.R;
import tellh.com.recyclertreeview_lib.LayoutItemType;

@AutoValue
public abstract class Group implements LayoutItemType, Node {

    @NonNull
    private List<Node> nodes = new ArrayList<>();

    @NonNull
    public abstract String getTitle();

    @NonNull
    public static Group create(String title) {
        return new AutoValue_Group(title);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_group;
    }

    @Override
    @NonNull
    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        if (node != null) {
            nodes.add(node);
        }
    }
}
