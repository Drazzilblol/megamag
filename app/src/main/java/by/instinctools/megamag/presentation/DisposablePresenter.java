package by.instinctools.megamag.presentation;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DisposablePresenter<V extends MvpView> extends BasePresenter<V> {

    @NonNull
    private CompositeDisposable disposables = new CompositeDisposable();

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

    @Override
    public void attach(@NonNull V view) {
        super.attach(view);
        if (disposables.isDisposed()) {
            disposables = new CompositeDisposable();
        }
    }
}
