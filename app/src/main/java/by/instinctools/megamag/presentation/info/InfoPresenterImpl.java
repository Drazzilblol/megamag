package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
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
            view.showData(initTreeData(infoList));
        }
    }

    @Override
    public List<TreeNode> initTreeData(@NonNull List<Info> infoList) {
        List<TreeNode> nodes = new ArrayList<>();
        for (Info info : infoList) {
            if (TextUtils.isEmpty(info.getTitle())) {
                nodes.add(new TreeNode<>(new NodeInfo(info.getText())));
            } else {
                nodes.add(buildTree(info));
            }
        }
        return nodes;
    }

    private TreeNode<NodeGroup> buildTree(@NonNull Info info) {
        TreeNode<NodeGroup> root = new TreeNode<>(new NodeGroup(info.getTitle()));
        if (info.getInfoList().size() == 0 && !TextUtils.isEmpty(info.getText())) {
            root.addChild(new TreeNode<>(new NodeInfo(info.getText())));
        } else {
            for (Info i : info.getInfoList()) {
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
