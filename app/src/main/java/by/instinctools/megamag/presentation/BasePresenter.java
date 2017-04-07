package by.instinctools.megamag.presentation;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MVPView> implements MVPPresenter {
    private WeakReference<V> viewReference;

    @Override
    public void attach(Object view) {
        this.viewReference = new WeakReference((V) view);
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
