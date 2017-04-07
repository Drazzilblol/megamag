package by.instinctools.megamag.presentation;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MVPView> implements MVPPresenter<V> {

    private WeakReference<V> viewReference;

    @Override
    public void attach(V view) {
        this.viewReference = new WeakReference<>(view);
    }

    @Override
    public void detach() {
        if (viewReference != null) {
            viewReference.clear();
        }
    }

    public V getView() {
        if (viewReference != null) {
            return viewReference.get();
        }else {
            return null;
        }
    }
}
