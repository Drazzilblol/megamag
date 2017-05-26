package by.instinctools.megamag.presentation.main.announcements.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
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
            notifyItemRangeInserted(0, size - 1);
        }

        Iterator<Announcement> iterator = this.announcements.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            Announcement item = iterator.next();
            int result = compare(announcements, item);
            if (result == -1) {
                iterator.remove();
                notifyItemRemoved(i);
                i--;
            }
            i++;
        }

        iterator = announcements.iterator();
        i = 0;
        while (iterator.hasNext()) {
            Announcement item = iterator.next();
            int result = compare(this.announcements, item);
            if (result == -1) {
                this.announcements.add(i, item);
                notifyItemInserted(i);
                i++;
            }
            i++;
        }

        for (int j = 0; j < this.announcements.size(); j++) {
            Announcement oldAnnouncement = this.announcements.get(j);
            Announcement newAnnouncement = announcements.get(j);
            if (!oldAnnouncement.equals(newAnnouncement)) {
                this.announcements.set(j, newAnnouncement);
                notifyItemChanged(j);
            }
        }
    }
    
    private int compare(@NonNull List<Announcement> announcements, Announcement item) {
        int res = -1;
        for (int i = 0; i < announcements.size(); i++) {
            if (TextUtils.equals(item.getTitle(), announcements.get(i).getTitle())) {
                res = i;
            }
        }
        return res;
    }
}
