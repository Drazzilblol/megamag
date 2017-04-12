package by.instinctools.megamag.presentation.main.announcements.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.instinctools.megamag.R;
import by.instinctools.megamag.data.models.Announcement;

public class AnnouncementsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Announcement> announcements;

    public AnnouncementsListAdapter(List<Announcement> announcementList) {
        announcements = announcementList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.announcements_item_view, parent, false);
        return new AnnouncementHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AnnouncementHolder) holder).onBindData(announcements.get(position));
    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }
}
