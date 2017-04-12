package by.instinctools.megamag.presentation;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

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
}
