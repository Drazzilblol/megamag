package by.instinctools.megamag.presentation.main.announcements;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.presentation.MvpView;

interface AnnouncementsView extends MvpView {

    void showData(@NonNull List<Announcement> announcementList);

    void hideData();
}
