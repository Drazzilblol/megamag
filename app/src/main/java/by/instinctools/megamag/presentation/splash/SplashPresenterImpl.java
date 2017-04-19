package by.instinctools.megamag.presentation.splash;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.UnknownError;
import by.instinctools.megamag.domain.IncrementAndGetStartupCounterUseCase;
import by.instinctools.megamag.domain.UseCase;
import by.instinctools.megamag.presentation.DisposablePresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class SplashPresenterImpl extends DisposablePresenter<SplashView> implements SplashPresenter {

    private static final long DELAY_MILLIS = 1000L;
    private static final int FRESH_START_COUNT = 1;

    @NonNull
    UseCase<Integer> incrementAndGetCounterUseCase = new IncrementAndGetStartupCounterUseCase();

    @Override
    public void attach(@NonNull SplashView view) {
        super.attach(view);
        view.showProgress();
        addDisposable(
                Observable.timer(DELAY_MILLIS, TimeUnit.MILLISECONDS)
                        .flatMap(c -> incrementAndGetCounterUseCase.execute())
                        .filter(counter -> counter > 0)
                        .map(counter -> counter == FRESH_START_COUNT)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .firstOrError()
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    private void onLoadSuccess(boolean isFreshStart) {
        if (isViewAttached()) {
            SplashView view = getView();
            view.hideProgress();
            if (isFreshStart) {
                view.goToProfileScreen();
            } else {
                view.goToMainScreen();
            }
        }
    }

    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            SplashView view = getView();
            view.hideProgress();
            showError(throwable);
        }
    }
}
