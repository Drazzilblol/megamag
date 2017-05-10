package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.data.info.items.InfoItem;
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

class InfoPresenterImpl extends DisposablePresenter<InfoView> implements InfoPresenter {

    private static final int EMPTY_LIST_SIZE = 0;

    private static String type;

    private int infoId;

    @NonNull
    GetInfoUseCase infoUseCase = new GetInfoUseCase();

    @Override
    public void setInitialValue(int infoId) {
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
                        .flatMap(Observable::fromIterable)
                        .map(this::buildTree)
                        .toList()
                        .toObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::onLoadSuccess,
                                this::onLoadError
                        )
        );
    }

    @DebugLog
    private void onLoadSuccess(@NonNull List<TreeNode> infoList) {
        if (isViewAttached()) {
            InfoView view = getView();
            view.hideProgress();
            view.hideError();
            view.showData(infoList);
            view.showToolbar(type);
        }
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

        type = info.getType();

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
    private void onLoadError(@NonNull Throwable throwable) {
        if (isViewAttached()) {
            InfoView view = getView();
            view.hideProgress();
            view.hideData();
            showError(throwable);
        }
    }


}
