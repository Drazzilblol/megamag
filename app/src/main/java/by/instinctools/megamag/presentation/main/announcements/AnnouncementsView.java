package by.instinctools.megamag.presentation.main.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.data.models.Announcement;
import by.instinctools.megamag.presentation.MvpView;

interface AnnouncementsView extends MvpView {

    void initRecyclerView(@NonNull List<Announcement> announcementList);
}
