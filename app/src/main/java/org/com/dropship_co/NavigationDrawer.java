package org.com.dropship_co;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import org.com.dropship_co.Fragments.HomeScreen;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class NavigationDrawer extends AppCompatActivity implements View.OnClickListener{

    private DuoDrawerLayout drawerLayout;
    private DuoDrawerToggle drawerToggle;
    private DuoMenuView menuView;
    private Toolbar toolbar;

    LinearLayout homeBtn, categoryBtn, profileBtn, loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = findViewById(R.id.drawer);
        drawerToggle = new DuoDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        menuView = findViewById(R.id.menuview);
        setMenuOnClickListener(menuView);
        Fragment current = new HomeScreen();
        getSupportFragmentManager().beginTransaction().add(R.id.container,current).commit();
        getSupportActionBar().setTitle("Home");

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }

    private void setMenuOnClickListener(DuoMenuView menuView) {
        homeBtn = menuView.findViewById(R.id.nav_home);
        categoryBtn = menuView.findViewById(R.id.nav_category);
        profileBtn = menuView.findViewById(R.id.nav_Profile);
        loginBtn = menuView.findViewById(R.id.nav_login);

        homeBtn.setOnClickListener(this);
        categoryBtn.setOnClickListener(this);
        profileBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeScreen()).commit();
                getSupportActionBar().setTitle("Home");
                drawerLayout.closeDrawer();
                break;
            case R.id.nav_login:
                Intent authIntent = new Intent(getBaseContext(),AuthUser.class);
                drawerLayout.closeDrawer();
                startActivity(authIntent);
                break;
        }
    }
}
