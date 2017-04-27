package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetInfoUseCase;
import by.instinctools.megamag.domain.UseCase;
import by.instinctools.megamag.domain.models.Info;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class InfoPresenterImpl extends DisposablePresenter<InfoView> implements InfoPresenter {

    private static final int EMPTY_LIST_SIZE = 0;

    @NonNull
    UseCase<List<Info>> infoUseCase = new GetInfoUseCase();

    @Override
    public void setInitialValue(@NonNull String activityId) {

    }

    @Override
    public void attach(@NonNull InfoView view) {
        super.attach(view);
        view.showProgress();
        addDisposable(
                infoUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void onLoadSuccess(@NonNull List<Info> infoList) {
        if (isViewAttached()) {
            if (infoList.size() != EMPTY_LIST_SIZE) {
                InfoView view = getView();
                view.hideProgress();
                view.hideError();
                view.showData(infoList);
            } else {
                onLoadError(new ErrorException(new NoDataError()));
            }
        }
    }

    @DebugLog
    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            InfoView view = getView();
            view.hideProgress();
            view.hideData();
            showError(throwable);
        }
    }
}
