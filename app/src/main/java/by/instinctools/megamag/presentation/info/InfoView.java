package by.instinctools.megamag.presentation.info;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.instinctools.megamag.presentation.MvpView;
import tellh.com.recyclertreeview_lib.TreeNode;


interface InfoView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(@NonNull List<TreeNode> infoList);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setToolbarTitle(@NonNull String title);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideData();
}
