package by.instinctools.megamag.presentation;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MVPView> implements MVPPresenter {
    private WeakReference<V> viewReference;

    @Override
    public void attach(Object view) {
        V thisView = (V) view;
        this.viewReference = new WeakReference(thisView);
    }

    @Override
    public void detach() {
        if (viewReference != null) {
            viewReference.clear();
        }
    }

    public V getViewReference() {
        return viewReference.get();
    }
}
