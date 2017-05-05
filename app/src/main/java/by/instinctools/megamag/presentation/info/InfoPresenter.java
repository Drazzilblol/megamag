package by.instinctools.megamag.presentation.info;

import by.instinctools.megamag.presentation.MvpPresenter;

interface InfoPresenter extends MvpPresenter<InfoView> {

    void setInitialValue(int activityId);
}
