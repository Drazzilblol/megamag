package by.instinctools.megamag.presentation;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.UnknownError;
import timber.log.Timber;

public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private WeakReference<V> viewReference;

    @Override
    public void attach(@NonNull V view) {
        this.viewReference = new WeakReference<>(view);
    }

    @Override
    public void detach() {
        if (viewReference != null) {
            viewReference.clear();
        }
    }

    @NonNull
    protected V getView() {
        V view = viewReference.get();
        if (view != null) {
            return view;
        } else {
            throw new RuntimeException();
        }
    }

    protected boolean isViewAttached() {
        return viewReference != null;
    }

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
        if (isViewAttached()) {
            getView().showError(error.getError());
        }
    }

    protected void showUnknownError() {
        if (isViewAttached()) {
            getView().showError(new UnknownError());
        }
    }
}
