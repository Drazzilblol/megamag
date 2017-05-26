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

        if (currentSize == 0) {
            this.announcements.addAll(announcements);
            notifyDataSetChanged();
        }

        if (currentSize > size) {
            for (int i = 0; i < currentSize; i++) {
                Announcement item = this.announcements.get(i);
                int itemIndex = announcements.indexOf(item);
                if (itemIndex == -1 && currentSize > size) {
                    this.announcements.remove(i);
                    notifyItemRemoved(i);
                    currentSize = this.announcements.size();
                }
            }
        }

        if (currentSize < size) {
            for (int i = 0; i < size; i++) {
                Announcement item = announcements.get(i);
                int itemIndex = this.announcements.indexOf(item);
                if (itemIndex == -1 && currentSize < size) {
                    this.announcements.add(i, item);
                    notifyItemInserted(i);
                    currentSize = this.announcements.size();
                }
            }
        }

        if (currentSize == size) {
            for (int i = 0; i < size; i++) {
                Announcement item = announcements.get(i);
                int itemIndex = this.announcements.indexOf(item);
                if (itemIndex == -1) {
                    this.announcements.set(i, item);
                    notifyItemChanged(i);
                }
            }
        }
    }
}
