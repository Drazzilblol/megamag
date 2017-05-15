package by.instinctools.megamag.presentation.event_details;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.Announcement;
import by.instinctools.megamag.domain.models.Event;
import by.instinctools.megamag.presentation.MvpView;

interface EventDetailsView extends MvpView{

    void showData(@NonNull Event event);

    void hideData();
}
