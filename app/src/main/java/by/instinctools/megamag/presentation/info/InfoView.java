package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.presentation.MvpView;
import tellh.com.recyclertreeview_lib.TreeNode;

interface InfoView extends MvpView {

    void showData(@NonNull List<TreeNode> infoList);

    void setToolbarTitle(@NonNull String title);

    void hideData();
}
