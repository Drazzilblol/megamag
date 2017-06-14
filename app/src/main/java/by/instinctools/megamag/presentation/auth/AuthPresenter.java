package by.instinctools.megamag.presentation.auth;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import by.instinctools.megamag.domain.LoginUseCase;
import by.instinctools.megamag.domain.models.User;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class AuthPresenter extends DisposablePresenter<AuthView> {

    private LoginUseCase loginUseCase = new LoginUseCase();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        addDisposable(
                loginUseCase.execute("asd", "asdasd")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadInfoSuccess,
                                this::onLoadInfoError
                        )
        );
    }

    @DebugLog
    private void onLoadInfoSuccess(@NonNull User infoList) {
    }

    @DebugLog
    private void onLoadInfoError(@NonNull Throwable throwable) {
        showError(throwable);
    }
}
