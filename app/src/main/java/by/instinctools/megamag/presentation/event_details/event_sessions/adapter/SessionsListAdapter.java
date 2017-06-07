package by.instinctools.megamag.presentation.event_details.event_sessions.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

import by.instinctools.megamag.common.diff_util.BaseDiffAdapter;
import by.instinctools.megamag.domain.models.EventSession;

public class SessionsListAdapter extends BaseDiffAdapter<SessionsHolder, List<EventSession>> {

    @Override
    public SessionsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SessionsHolder(parent);
    }

    @Override
    public void onBindViewHolder(SessionsHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    @Override
    public boolean areItemsTheSame(@NonNull List<EventSession> oldItem, @NonNull List<EventSession> newItem) {
        return false;
    }
}
