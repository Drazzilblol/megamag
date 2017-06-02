package by.instinctools.megamag.presentation;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.errors.Error;

public interface MvpView extends com.arellomobile.mvp.MvpView {

    void showError(@NonNull Error error);

    void hideError();

    void showProgress();

    void hideProgress();
}
