package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.Info;
import by.instinctools.megamag.presentation.MvpView;

interface InfoView extends MvpView {

    void showData(@NonNull List<Info> infoList);

    void hideData();
}
