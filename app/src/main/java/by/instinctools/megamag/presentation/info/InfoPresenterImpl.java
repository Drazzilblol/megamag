package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.domain.GetInfoUseCase;
import by.instinctools.megamag.domain.models.Info;
import by.instinctools.megamag.presentation.DisposablePresenter;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class InfoPresenterImpl extends DisposablePresenter<InfoView> implements InfoPresenter {

    private static final int EMPTY_LIST_SIZE = 0;

    private String infoId;

    @NonNull
    GetInfoUseCase infoUseCase = new GetInfoUseCase();

    @Override
    public void setInitialValue(@NonNull String infoId) {
        this.infoId = infoId;
    }

    @Override
    public void attach(@NonNull InfoView view) {
        super.attach(view);
        view.showProgress();
        addDisposable(
                infoUseCase.execute(infoId)
                        .filter(infoList -> infoList.size() > EMPTY_LIST_SIZE)
                        .switchIfEmpty(Observable.error(new ErrorException(new NoDataError())))
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
            InfoView view = getView();
            view.hideProgress();
            view.hideError();
            view.showData(infoList);
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
