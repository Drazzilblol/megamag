package by.instinctools.megamag.presentation.main.announcements.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.domain.models.Announcement;

class AnnouncementHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.announcement_details_view)
    TextView detailsTextView;

    @BindView(R.id.announcement_description_view)
    TextView descriptionTextView;

    @BindView(R.id.announcement_cover)
    ImageView imageView;

    private static View getView(@NonNull ViewGroup parent) {
        return LayoutInflater.from(parent.getContext())
                .inflate(R.layout.announcements_item, parent, false);
    }

    AnnouncementHolder(@NonNull ViewGroup parent) {
        super(getView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull Announcement announcement) {
        detailsTextView.setText(announcement.getDetails());
        descriptionTextView.setText(announcement.getDescription());
    }
}
