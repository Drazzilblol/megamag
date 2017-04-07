package by.instinctools.megamag.presentation;


public interface BasePresenter<V> {

    void attach(V v);
    void detach();

}
