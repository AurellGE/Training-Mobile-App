package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {

    Button logout;
    TextView username;

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.btn_logout);
        username = findViewById(R.id.tv_username);

        Intent intent = getIntent();
        String tempUsername = intent.getStringExtra("account_username");

        username.setText(tempUsername);

        logout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
        });

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);

        setViewPager2(viewPager2);

        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> {
            tab.setText(pageAdapter.getFragmentTitle(position));
        })).attach();
    }

    private void setViewPager2(ViewPager2 viewPager2) {
        if (pageAdapter == null) {
            pageAdapter = new PageAdapter(this);
            pageAdapter.addFragment(new HomeFragment(), "Home");
            pageAdapter.addFragment(new DownloadFragment(), "Download");
            viewPager2.setAdapter(pageAdapter);
        }
    }
}