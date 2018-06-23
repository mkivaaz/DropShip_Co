package org.com.dropship_co;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import org.com.dropship_co.Adapter.AuthPagerAdapter;
import org.com.dropship_co.Fragments.LoginScreen;
import org.com.dropship_co.Fragments.SignUpScreen;

public class AuthUser extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_user);

        initiateItems();
    }

    private void initiateItems() {
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        addTabs(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(1);
        setTabs();
    }

    private void setTabs() {
//        tabLayout.getTabAt(0).setText("Login");
//        tabLayout.getTabAt(1).setText("Sign Up");
    }

    private void addTabs(ViewPager viewPager) {
        AuthPagerAdapter adapter = new AuthPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new LoginScreen(), "Login");
        adapter.addFrag(new SignUpScreen(),"Sign Up");
        viewPager.setAdapter(adapter);
    }
}
