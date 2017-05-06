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
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.instinctools.megamag.R;
import by.instinctools.megamag.common.errors.Error;
import by.instinctools.megamag.common.utils.Navigator;
import by.instinctools.megamag.domain.models.MenuDomain;
import by.instinctools.megamag.presentation.main.announcements.AnnouncementsFragment;
import by.instinctools.megamag.presentation.main.menu.MenuPresenter;
import by.instinctools.megamag.presentation.main.menu.MenuPresenterImpl;
import by.instinctools.megamag.presentation.main.menu.MenuView;
import by.instinctools.megamag.presentation.main.menu.models.MenuViewModel;
import by.instinctools.megamag.presentation.main.tickets.TicketsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView, MenuView, View.OnClickListener {

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    Button button;

    TextView profileView;

    @NonNull
    private MainPresenter mainPresenter = new MainPresenterImpl();

    @NonNull
    private MenuPresenter menuPresenter = new MenuPresenterImpl();

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.announcements_toolbar_title);
        setSupportActionBar(toolbar);

        goToAnnouncementsScreen();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        button = (Button) header.findViewById(R.id.nav_header_dropdown_button);
        profileView = (TextView) header.findViewById(R.id.nav_header_profile);
        profileView.setOnClickListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
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
    protected void onStart() {
        super.onStart();
        mainPresenter.attach(this);
        menuPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detach();
        menuPresenter.detach();
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
    public void showMenu(@NonNull List<MenuViewModel> menuList) {
        Menu menu = navigationView.getMenu();
        menu.clear();
        for (MenuViewModel menuView : menuList) {
            menu.add(menuView.getTargetId(), menuView.getMenuId(), Menu.NONE, menuView.getTitle());
        }
    }

    @Override
    public void addMenuItem(@NonNull MenuDomain menuDomain, int groupId) {
        Menu menu = navigationView.getMenu();
        menu.add(groupId, menuDomain.getMenuId(), Menu.NONE, menuDomain.getTitle());
    }

    @Override
    public void onClick(View v) {
        if (v.isSelected()) {
            v.setSelected(false);
            button.setBackgroundResource(R.drawable.ic_arrow_drop_down_white_24dp);
        } else {
            v.setSelected(true);
            button.setBackgroundResource(R.drawable.ic_arrow_drop_up_white_24dp);
        }
    }
}
