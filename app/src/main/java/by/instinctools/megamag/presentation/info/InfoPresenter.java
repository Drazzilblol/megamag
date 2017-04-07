package by.instinctools.megamag.presentation.info;

import by.instinctools.megamag.presentation.MVPPresenter;

interface InfoPresenter extends MVPPresenter<InfoView> {

    void setInitialData(String activityId);
}
