package by.instinctools.megamag.presentation;


public interface MVPPresenter<V> {

    void attach(V v);
    void detach();
}
