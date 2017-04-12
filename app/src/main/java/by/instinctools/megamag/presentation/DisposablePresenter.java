package by.instinctools.megamag.presentation;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DisposablePresenter<V extends MvpView> extends BasePresenter<V> {

    @NonNull
    private final CompositeDisposable disposables = new CompositeDisposable();

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    protected void dispose() {
        disposables.dispose();
    }

    @Override
    public void detach() {
        super.detach();
        disposables.dispose();
    }
}
