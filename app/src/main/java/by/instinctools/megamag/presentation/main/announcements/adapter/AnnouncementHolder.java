package by.instinctools.megamag.presentation.main.announcements.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.utils.ImageUtils;
import by.instinctools.megamag.domain.models.Announcement;

class AnnouncementHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.announcement_title)
    TextView titleView;

    @BindView(R.id.announcement_place)
    TextView placeView;

    @BindView(R.id.announcement_details_view)
    TextView detailsTextView;

    @BindView(R.id.announcement_description_view)
    TextView descriptionTextView;

    @BindView(R.id.announcement_cover)
    ImageView imageView;

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.item_announcement, parent, false);
    }

    AnnouncementHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull Announcement announcement) {
        String details = announcement.getDetails();
        String description = announcement.getDescription();

        titleView.setText(announcement.getTitle());
        placeView.setText(announcement.getPlace());

        detailsTextView.setText(details);
        descriptionTextView.setText(description);
        ImageUtils.loadImageWithBlur(
                itemView.getContext(),
                imageView,
                announcement.getCoverUrl()
        );

        if (TextUtils.isEmpty(details)) {
            detailsTextView.setVisibility(View.GONE);
        } else {
            detailsTextView.setVisibility(View.VISIBLE);
        }
        if (TextUtils.isEmpty(description)) {
            descriptionTextView.setVisibility(View.GONE);
        } else {
            detailsTextView.setVisibility(View.VISIBLE);
        }
    }
}
