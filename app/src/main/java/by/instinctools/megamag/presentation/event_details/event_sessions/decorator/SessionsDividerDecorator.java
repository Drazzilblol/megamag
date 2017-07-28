package by.instinctools.megamag.presentation.event_details.event_sessions.decorator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import by.instinctools.megamag.R;
import by.instinctools.megamag.presentation.event_details.event_sessions.adapter.ConcreteSessionListAdapter;

public class SessionsDividerDecorator extends RecyclerView.ItemDecoration {

    private Drawable divider;
    private int offset;

    public SessionsDividerDecorator(@NonNull Context context) {
        divider = context.getResources().getDrawable(R.drawable.line_divider);
        offset = context.getResources().getDimensionPixelSize(R.dimen.event_details_session_list_item_offset);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();

        for (int i = 1; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (ConcreteSessionListAdapter.PLACE == parent.getAdapter().getItemViewType(parent.getChildAdapterPosition(child))) {

                int top = child.getTop() - offset / 2;
                int bottom = top + divider.getIntrinsicHeight();

                divider.setBounds(left, top, right, bottom);
                divider.draw(c);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        if (position == parent.getAdapter().getItemCount() - 1) {
            outRect.setEmpty();
        } else if (position == 0) {
            outRect.setEmpty();
        } else if (ConcreteSessionListAdapter.PLACE == parent.getAdapter().getItemViewType(position)) {
            outRect.set(0, offset, 0, 0);
        } else {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }
}