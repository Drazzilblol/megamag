package by.instinctools.megamag.presentation.event_details.event_comments.adapter;

import android.content.Context;
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
import by.instinctools.megamag.common.utils.ImageUtils;
import by.instinctools.megamag.domain.models.EventComment;

class CommentHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_details_comment_text)
    TextView textView;

    @BindView(R.id.item_details_comment_user_name)
    TextView userNameView;

    @BindView(R.id.item_details_comment_avatar)
    ImageView avatarView;

    private static View inflateView(@NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.item_details_comment, parent, false);
    }

    CommentHolder(@NonNull ViewGroup parent) {
        super(inflateView(parent));
        ButterKnife.bind(this, itemView);
    }

    void bindData(@NonNull EventComment comment) {
        textView.setText(comment.getText());
        userNameView.setText(comment.getUserName());
        ImageUtils.loadImage(
                itemView.getContext(),
                avatarView,
                comment.getAvatarUrl()
        );
    }
}
