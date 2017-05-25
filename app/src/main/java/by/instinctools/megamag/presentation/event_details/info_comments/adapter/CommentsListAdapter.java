package by.instinctools.megamag.presentation.event_details.info_comments.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.domain.models.EventComment;

public class CommentsListAdapter extends RecyclerView.Adapter<CommentHolder> {

    @NonNull
    private final List<EventComment> comments = new ArrayList<>();

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentHolder(parent);
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        holder.bindData(comments.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void setComments(@NonNull List<EventComment> comments) {
        this.comments.clear();
        this.comments.addAll(comments);
        notifyDataSetChanged();
    }
}
