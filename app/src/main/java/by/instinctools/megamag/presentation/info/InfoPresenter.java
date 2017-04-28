package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.domain.models.Info;
import by.instinctools.megamag.presentation.MvpPresenter;
import tellh.com.recyclertreeview_lib.TreeNode;

interface InfoPresenter extends MvpPresenter<InfoView> {

    void setInitialValue(@NonNull String activityId);

    List<TreeNode> initTreeData(@NonNull List<Info> infoList);
}
