package by.instinctools.megamag.presentation.splash;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import by.instinctools.megamag.domain.IncrementAndGetStartupCounterUseCase;
import by.instinctools.megamag.domain.UseCase;
import by.instinctools.megamag.presentation.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class SplashPresenterImpl extends BasePresenter<SplashView> implements SplashPresenter {

    private static final long DELAY_MILLIS = 1000L;

    @NonNull
    UseCase<Integer> incrementAndGetCounterUseCase = new IncrementAndGetStartupCounterUseCase();

    @Override
    public void attach(@NonNull SplashView view) {
        super.attach(view);

        incrementAndGetCounterUseCase
                .execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(DELAY_MILLIS, TimeUnit.MILLISECONDS)
                .subscribe(this::navigate);
    }

    private void navigate(Integer value) {
        final SplashView splashView = getView();
        if (splashView != null) {
            switch (value) {
                case 1:
                    splashView.goToProfileScreen();
                    break;
                default:
                    splashView.goToMainScreen();
                    break;
            }
        }
    }

    @Override
    public void detach() {
        super.detach();
    }
}
