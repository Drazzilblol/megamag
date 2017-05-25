package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.data.info.items.InfoItem;
import by.instinctools.megamag.domain.GetInfoTitleUseCase;
import by.instinctools.megamag.domain.GetInfoUseCase;
import by.instinctools.megamag.domain.models.Info;
import by.instinctools.megamag.presentation.DisposablePresenter;
import by.instinctools.megamag.presentation.info.adapter.nodes.NodeGroup;
import by.instinctools.megamag.presentation.info.adapter.nodes.NodeInfo;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import tellh.com.recyclertreeview_lib.TreeNode;
import timber.log.Timber;

class InfoPresenterImpl extends DisposablePresenter<InfoView> implements InfoPresenter {

    private static final int EMPTY_LIST_SIZE = 0;

    private int infoId;

    @NonNull
    private GetInfoUseCase infoUseCase = new GetInfoUseCase();

    @NonNull
    private GetInfoTitleUseCase getInfoTitleUseCase = new GetInfoTitleUseCase();

    @Override
    public void setInitialValue(int infoId) {
        this.infoId = infoId;
    }

    @Override
    public void attach(@NonNull InfoView view) {
        super.attach(view);
        view.showProgress();
        loadInfo();
        loadInfoToolbarTitle();
    }

    private void loadInfo() {
        addDisposable(
                infoUseCase.execute(infoId)
                        .filter(infoList -> infoList.size() > EMPTY_LIST_SIZE)
                        .switchIfEmpty(Observable.error(new ErrorException(new NoDataError())))
                        .flatMap(Observable::fromIterable)
                        .map(this::buildTree)
                        .toList()
                        .toObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadInfoSuccess,
                                this::onLoadInfoError
                        )
        );
    }

    private TreeNode buildTree(@NonNull Info info) {
        List<InfoItem> infoItems = info.getItemList();
        List<Info> infoList = info.getInfoList();

        boolean hasTitle = !TextUtils.isEmpty(info.getTitle());
        boolean hasChildes = infoList.size() > 0;
        boolean hasContent = infoItems.size() > 0;

        if (!hasChildes && !hasContent) {
            throw new ErrorException(new NoDataError());
        }

        TreeNode root;
        if (!hasChildes) {
            if (!hasTitle) {
                root = new TreeNode<>(new NodeInfo(infoItems));
            } else {
                root = new TreeNode<>(new NodeGroup(info.getTitle()));
                root.addChild(new TreeNode<>(new NodeInfo(infoItems)));
                return root;
            }
        } else {
            root = new TreeNode<>(new NodeGroup(info.getTitle()));
            for (Info i : infoList) {
                root.addChild(buildTree(i));
            }
        }
        return root;
    }

    @DebugLog
    private void onLoadInfoSuccess(@NonNull List<TreeNode> infoList) {
        if (isViewAttached()) {
            InfoView view = getView();
            view.hideProgress();
            view.hideError();
            view.showData(infoList);
        }
    }

    private void loadInfoToolbarTitle() {
        addDisposable(
                getInfoTitleUseCase.execute(infoId)
                        .switchIfEmpty(Observable.error(new ErrorException(new NoDataError())))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadToolbarTitleSuccess,
                                this::onLoadToolbarTitleError)
        );
    }

    @DebugLog
    private void onLoadToolbarTitleSuccess(@NonNull String title) {
        if (isViewAttached()) {
            InfoView view = getView();
            view.setToolbarTitle(title);
        }
    }

    @DebugLog
    private void onLoadInfoError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            InfoView view = getView();
            view.hideProgress();
            view.hideData();
            showError(throwable);
        }
    }

    @DebugLog
    private void onLoadToolbarTitleError(@NonNull Throwable throwable) {
        Timber.i(throwable);
    }
}
