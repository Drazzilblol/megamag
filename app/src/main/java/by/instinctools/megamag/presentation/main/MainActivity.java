package by.instinctools.megamag.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.utils.Navigator;
import by.instinctools.megamag.domain.models.Menu;
import by.instinctools.megamag.presentation.main.announcements.AnnouncementsFragment;
import by.instinctools.megamag.presentation.main.menu.MenuPresenter;
import by.instinctools.megamag.presentation.main.menu.MenuView;
import by.instinctools.megamag.presentation.main.tickets.TicketsFragment;


public class MainActivity extends MvpAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MenuView, View.OnClickListener {

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    TextView profileView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ActionBar actionBar;

    @InjectPresenter(type = PresenterType.GLOBAL)
    MenuPresenter menuPresenter;

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolbar();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        profileView = (TextView) header.findViewById(R.id.nav_header_profile);
        profileView.setOnClickListener(this);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
    }

    @Override
    public void goToAnnouncementsScreen() {
        Fragment fragment = AnnouncementsFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.activity_main_fragment_container, fragment)
                .commit();
    }

    @Override
    public void goToTicketsScreen() {
        Fragment fragment = TicketsFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.activity_main_fragment_container, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        menuPresenter.onMenuPressed(id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showError(@NonNull Error error) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void goToInfoScreen(int infoId) {
        Navigator.goToInfoScreen(this, infoId);
    }

    @Override
    public void showMenu(@NonNull List<Menu> menuList) {
        android.view.Menu menu = navigationView.getMenu();
        menu.clear();
        for (Menu menuView : menuList) {
            int i = menuView.getGroupType().getId();
            menu.add(i, menuView.getType().getId(), android.view.Menu.NONE, menuView.getTitle())
                    .setIcon(menuView.getIcon());
        }
    }

    @Override
    public void onClick(View v) {
        if (v.isSelected()) {
            v.setSelected(false);
            menuPresenter.onProfilePressed(true);
        } else {
            v.setSelected(true);
            menuPresenter.onProfilePressed(false);
        }
    }

    @Override
    public void showTitle(@NonNull String title) {
        actionBar.setTitle(title);
    }
}
