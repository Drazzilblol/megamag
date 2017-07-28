package by.instinctools.megamag.presentation.main.announcements.adapter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;

import by.instinctools.megamag.common.diff_util.BaseDiffAdapter;
import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.presentation.main.callbacks.OnItemClickListener;

public class AnnouncementsListAdapter extends BaseDiffAdapter<AnnouncementHolder, Announcement> {

    @NonNull
    private final OnItemClickListener listener;

    public AnnouncementsListAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public AnnouncementHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnnouncementHolder(parent, listener);
    }

    @Override
    public void onBindViewHolder(AnnouncementHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    @Override
    public boolean areItemsTheSame(@NonNull Announcement oldItem, @NonNull Announcement newItem) {
        return TextUtils.equals(oldItem.getTitle(), newItem.getTitle());
    }
}
