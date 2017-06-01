package by.instinctools.megamag.presentation;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.UnknownError;
import timber.log.Timber;

abstract class BasePresenter<V extends MvpView> extends com.arellomobile.mvp.MvpPresenter<V> {

    protected void showError(@NonNull Throwable throwable) {
        if (throwable instanceof ErrorException) {
            Timber.i(throwable.getMessage());
            showError((ErrorException) throwable);
        } else {
            Timber.e(throwable, throwable.getMessage());
            showUnknownError();
        }
    }

    protected void showError(@NonNull ErrorException error) {
        getViewState().showError(error.getError());
    }

    protected void showUnknownError() {
        getViewState().showError(new UnknownError());
    }
}
