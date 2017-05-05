package by.instinctools.megamag.presentation.info.adapter.holders.child_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.utils.ImageUtils;
import by.instinctools.megamag.data.info.items.InfoItem;

public class InfoImageViewHolder extends InfoViewHolder {

    @BindView(R.id.item_info_image_view)
    ImageView imageView;

    public InfoImageViewHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
    }

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return layoutInflater.inflate(R.layout.item_info_image, parent, false);
    }

    @Override
    void bind(@NonNull InfoItem item) {
        ImageUtils.loadImage(
                itemView.getContext(),
                imageView,
                item.getData()
        );
    }
}
