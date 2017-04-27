package by.instinctools.megamag.domain.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import java.util.List;

import by.instinctools.megamag.R;
import tellh.com.recyclertreeview_lib.LayoutItemType;

@AutoValue
public abstract class Info implements LayoutItemType, Node {

    @NonNull
    public abstract String getText();

    @NonNull
    public static Info create(String text) {
        return new AutoValue_Info(text);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_info;
    }

    @Override
    public List<Node> getNodes() {
        return null;
    }
}
