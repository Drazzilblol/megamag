package by.instinctools.megamag.presentation.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.arellomobile.mvp.presenter.ProvidePresenterTag;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoIdError;
import by.instinctools.megamag.presentation.info.adapter.binders.GroupBinder;
import by.instinctools.megamag.presentation.info.adapter.binders.InfoBinder;
import by.instinctools.megamag.presentation.info.adapter.holders.GroupViewHolder;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewAdapter;

public class InfoActivity extends MvpAppCompatActivity implements InfoView {

    @NonNull
    private static final String INFO_ACTIVITY_SCREEN_ID = "INFO_ACTIVITY_SCREEN_ID";

    @BindView(R.id.info_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.info_error_view)
    TextView errorView;

    @BindView(R.id.info_progress_bar)
    ContentLoadingProgressBar progressBar;

    @BindView(R.id.info_toolbar)
    Toolbar toolbar;

    private ActionBar actionBar;

    @InjectPresenter
    InfoPresenter infoPresenter;

    public static Intent createIntent(@NonNull Context context, int id) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(INFO_ACTIVITY_SCREEN_ID, id);
        return intent;
    }

    @ProvidePresenterTag(presenterClass = InfoPresenter.class)
    String provideInfoPresenterTag() {
        return String.format("%s:id=%s", InfoPresenter.class.getSimpleName(), getInfoIdFromIntent());
    }

    @ProvidePresenter
    InfoPresenter provideInfoPresenter() {
        return new InfoPresenter(getInfoIdFromIntent());
    }

    private int getInfoIdFromIntent() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(INFO_ACTIVITY_SCREEN_ID)) {
            return intent.getIntExtra(INFO_ACTIVITY_SCREEN_ID, 0);
        } else {
            throw new ErrorException(new NoIdError());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void showData(@NonNull List<TreeNode> infoList) {
        initRecyclerView(infoList);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void initRecyclerView(List<TreeNode> list) {
        TreeViewAdapter adapter = new TreeViewAdapter(list, Arrays.asList(new InfoBinder(), new GroupBinder()));
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

    @Override
    public void setToolbarTitle(@NonNull String title) {
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
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
