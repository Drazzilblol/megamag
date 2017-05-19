package by.instinctools.megamag.presentation.event_details.info_page;

import android.support.annotation.NonNull;

import by.instinctools.megamag.domain.models.EventInfo;
import by.instinctools.megamag.presentation.MvpView;

interface EventInfoView extends MvpView {

    void showData(@NonNull EventInfo eventInfo);

    void hideData();
}
