package by.instinctools.megamag.presentation;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.errors.Error;

public interface MvpView {
    void showError(@NonNull Error error);
    void showProgress(boolean show);
}
