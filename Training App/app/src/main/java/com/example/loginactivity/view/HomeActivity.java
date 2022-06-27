package com.example.loginactivity.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.loginactivity.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {

    Button logout, toNbaList;
    TextView username;

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.btn_logout);
        toNbaList = findViewById(R.id.btn_toNbaList);
        username = findViewById(R.id.tv_username);

        Intent intent = getIntent();
        String tempUsername = intent.getStringExtra("account_username");

//        username.setText(tempUsername);

//        logout.setOnClickListener(v -> {
//            Intent logoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
//            startActivity(logoutIntent);
//        });

        toNbaList.setOnClickListener(view -> {
            Intent toNbaListIntent = new Intent(HomeActivity.this, NbaActivity.class);
            startActivity(toNbaListIntent);
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