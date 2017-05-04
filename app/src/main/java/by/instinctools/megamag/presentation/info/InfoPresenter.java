package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;

import by.instinctools.megamag.presentation.MvpPresenter;

interface InfoPresenter extends MvpPresenter<InfoView> {

    void setInitialValue(int activityId);
}
