package by.instinctools.megamag.presentation.event_details.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.presentation.event_details.info_comments.EventCommentFragment;
import by.instinctools.megamag.presentation.event_details.info_comments.EventCommentPresenter;
import by.instinctools.megamag.presentation.event_details.info_page.EventInfoFragment;

public class DetailsPageAdapter extends FragmentStatePagerAdapter {

    private final String eventId;

    public DetailsPageAdapter(@NonNull FragmentManager fm, @NonNull String eventId) {
        super(fm);
        this.eventId = eventId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return EventInfoFragment.newInstance(eventId);
            case 1:
                return EventInfoFragment.newInstance(eventId);
            case 2:
                return EventCommentFragment.newInstance(eventId);
            default:
                return EventInfoFragment.newInstance(eventId);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Context context = Application.getAppContext();
        switch (position) {
            case 0:
                return context.getString(R.string.details_view_pager_info);
            case 1:
                return context.getString(R.string.details_view_pager_session);
            case 2:
                return context.getString(R.string.details_view_pager_comments);
            default:
                return context.getString(R.string.details_view_pager_info);
        }
    }
}
