package by.instinctools.megamag.presentation.splash;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import by.instinctools.megamag.domain.IncrementAndGetStartupCounterUseCase;
import by.instinctools.megamag.domain.UseCase;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

class SplashPresenterImpl extends DisposablePresenter<SplashView> implements SplashPresenter {

    private static final long DELAY_MILLIS = 1000L;
    private static final int FRESH_START_COUNT = 1;

    @NonNull
    UseCase<Integer> incrementAndGetCounterUseCase = new IncrementAndGetStartupCounterUseCase();

    @DebugLog
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

    @DebugLog
    private void onLoadSuccess(boolean isFreshStart) {
        if (isViewAttached()) {
            SplashView view = getView();
            view.hideProgress();
            Timber.i("is fresh start: " + isFreshStart);
            if (isFreshStart) {
                view.goToProfileScreen();
            } else {
                view.goToMainScreen();
            }
        }
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            SplashView view = getView();
            view.hideProgress();
            showError(throwable);
        }
    }
}
