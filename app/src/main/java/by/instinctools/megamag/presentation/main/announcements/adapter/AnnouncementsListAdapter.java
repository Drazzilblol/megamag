package by.instinctools.megamag.presentation.main.announcements.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.domain.models.Announcement;

public class AnnouncementsListAdapter extends RecyclerView.Adapter<AnnouncementHolder> {

    @NonNull
    private final List<Announcement> announcements = new ArrayList<>();

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

    public void setAnnouncements(@NonNull List<Announcement> announcements) {
        int size = announcements.size();
        int currentSize = this.announcements.size();

        if (currentSize > size) {
            this.announcements.subList(size, currentSize).clear();
            notifyItemRangeRemoved(size, currentSize);
        }

        for (int i = 0; i < size; i++) {
            if (this.announcements.size() <= i) {
                this.announcements.add(announcements.get(i));
                notifyItemInserted(i);
            } else if (!this.announcements.get(i).equals(announcements.get(i))) {
                this.announcements.set(i, announcements.get(i));
                notifyItemChanged(i);
            }
        }
    }
}
