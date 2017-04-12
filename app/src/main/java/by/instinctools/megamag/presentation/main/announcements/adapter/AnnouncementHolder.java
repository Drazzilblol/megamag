package by.instinctools.megamag.presentation.main.announcements.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import by.instinctools.megamag.R;
import by.instinctools.megamag.data.models.Announcement;

class AnnouncementHolder extends RecyclerView.ViewHolder {

    @NonNull
    private TextView detailsTextView;

    @NonNull
    private TextView descriptionTextView;

    AnnouncementHolder(@NonNull View itemView) {
        super(itemView);
        detailsTextView = (TextView) itemView.findViewById(R.id.announcement_details_view);
        descriptionTextView = (TextView) itemView.findViewById(R.id.announcement_description_view);
    }

    void onBindData(@NonNull Announcement announcement) {
        detailsTextView.setText(announcement.getDetails());
        descriptionTextView.setText(announcement.getDescription());
    }
}
