package com.example.loginactivity.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.loginactivity.databinding.ActivityNbaBinding;
import com.example.loginactivity.viewModel.NbaViewModel;

public class NbaActivity extends AppCompatActivity {

    private ActivityNbaBinding mBinding;

    private NbaViewModel mNbaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityNbaBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mNbaViewModel = new ViewModelProvider(this).get(NbaViewModel.class);

        mNbaViewModel.callApi();

        mBinding.rvNbateams.setLayoutManager(new LinearLayoutManager(this));
        mNbaViewModel.getNbaTeamItems().observe(this, nbaTeamItemsName -> {
            mBinding.rvNbateams.setAdapter(new NbaTeamsAdapter(nbaTeamItemsName));
        });
    }
}