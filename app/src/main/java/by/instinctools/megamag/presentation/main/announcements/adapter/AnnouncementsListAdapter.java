package by.instinctools.megamag.presentation.main.announcements.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.domain.models.AnnouncementViewModel;

public class AnnouncementsListAdapter extends RecyclerView.Adapter<AnnouncementHolder> {

    @NonNull
    private final List<AnnouncementViewModel> announcements = new ArrayList<>();

    @Override
    public AnnouncementHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnnouncementHolder(parent);
    }

    @Override
    public void onBindViewHolder(AnnouncementHolder holder, int position) {
        holder.bindData(announcements.get(position));
    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }

    public void setAnnouncements(@NonNull List<AnnouncementViewModel> announcements) {
        this.announcements.clear();
        this.announcements.addAll(announcements);
        notifyDataSetChanged();
    }
}
