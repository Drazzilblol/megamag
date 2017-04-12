package by.instinctools.megamag.presentation;


import android.support.annotation.NonNull;

public interface MvpPresenter<V> {

    void attach(@NonNull V v);

    void detach();
}
