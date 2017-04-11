package by.instinctools.megamag.presentation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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

    @Nullable
    public V getView() {
        if (isViewAttached()) {
            return viewReference.get();
        } else {
            throw new RuntimeException();
        }
    }

    private boolean isViewAttached() {
        return viewReference != null;
    }
}
