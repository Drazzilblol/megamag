package by.instinctools.megamag.presentation.event_details.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.R;
import by.instinctools.megamag.presentation.event_details.info_page.EventInfoFragment;

public class DetailsPageAdapter extends FragmentStatePagerAdapter {

    public DetailsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return EventInfoFragment.newInstance();
            case 1:
                return EventInfoFragment.newInstance();
            case 2:
                return EventInfoFragment.newInstance();
            default:
                return EventInfoFragment.newInstance();
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
