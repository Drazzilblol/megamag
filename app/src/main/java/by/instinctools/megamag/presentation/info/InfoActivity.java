package by.instinctools.megamag.presentation.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.domain.models.Info;
import by.instinctools.megamag.presentation.info.adapter.binders.GroupBinder;
import by.instinctools.megamag.presentation.info.adapter.binders.InfoBinder;
import by.instinctools.megamag.presentation.info.adapter.holders.GroupViewHolder;
import by.instinctools.megamag.presentation.info.adapter.nodes.NodeGroup;
import by.instinctools.megamag.presentation.info.adapter.nodes.NodeInfo;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewAdapter;

public class InfoActivity extends AppCompatActivity implements InfoView {

    @NonNull
    public static final String INFO_ACTIVITY_SCREEN_ID = "INFO_ACTIVITY_SCREEN_ID";

    @BindView(R.id.info_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.info_error_view)
    TextView errorView;

    @BindView(R.id.info_progress_bar)
    ContentLoadingProgressBar progressBar;

    @NonNull
    private InfoPresenter infoPresenter = new InfoPresenterImpl();

    public static Intent createIntent(Context context, String id) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(INFO_ACTIVITY_SCREEN_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            infoPresenter.setInitialValue(intent.getStringExtra(INFO_ACTIVITY_SCREEN_ID));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        infoPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        infoPresenter.detach();
    }

    @Override
    public void showData(@NonNull List<Info> infoList) {
        recyclerView.setVisibility(View.VISIBLE);
        initTreeData(infoList);
    }

    private void initTreeData(List<Info> list) {
        List<TreeNode> nodes = new ArrayList<>();

        for (Info info : list) {
            if (TextUtils.isEmpty(info.getTitle())) {
                nodes.add(new TreeNode<>(new NodeInfo(info.getText())));
            } else {
                nodes.add(buildTree(info));
            }
        }

        TreeViewAdapter adapter = new TreeViewAdapter(nodes, Arrays.asList(new InfoBinder(), new GroupBinder()));
        adapter.setOnTreeNodeListener(new TreeViewAdapter.OnTreeNodeListener() {
            @Override
            public boolean onClick(TreeNode node, RecyclerView.ViewHolder holder) {
                if (!node.isLeaf()) {
                    onToggle(!node.isExpand(), holder);
                }
                return false;
            }

            @Override
            public void onToggle(boolean isExpand, RecyclerView.ViewHolder holder) {
                GroupViewHolder groupHolder = (GroupViewHolder) holder;
                final ImageView icon = groupHolder.getImageView();
                if (isExpand) {
                    icon.setImageResource(R.drawable.ic_remove_black_24dp);
                } else {
                    icon.setImageResource(R.drawable.ic_add_black_24dp);
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private TreeNode<NodeGroup> buildTree(Info info) {
        TreeNode<NodeGroup> root = new TreeNode<>(new NodeGroup(info.getTitle()));
        if (info.getInfoList().size() == 0 && !TextUtils.isEmpty(info.getText())) {
            root.addChild(new TreeNode<>(new NodeInfo(info.getText())));
        } else {
            for (Info i : info.getInfoList()) {
                if (!TextUtils.isEmpty(i.getTitle())) {
                    root.addChild(buildTree(i));
                } else {
                    TreeNode<NodeInfo> treeNode = new TreeNode<>(new NodeInfo(i.getText()));
                    root.addChild(treeNode);
                }
            }
        }
        return root;
    }

    @Override
    public void hideData() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showError(@NonNull Error error) {
        errorView.setText(error.getErrorMessage());
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.show();
    }

    @Override
    public void hideProgress() {
        progressBar.hide();
    }
}
