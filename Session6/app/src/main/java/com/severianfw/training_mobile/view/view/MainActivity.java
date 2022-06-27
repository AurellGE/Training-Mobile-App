package com.severianfw.training_mobile.view.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.severianfw.training_mobile.databinding.ActivityMainBinding;
import com.severianfw.training_mobile.view.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

//    private List<String> nbaTeamItemsName;

    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mMainViewModel.callApi();

        mBinding.rvNbaTeams.setLayoutManager(new LinearLayoutManager(this));
        mMainViewModel.getNbaTeamItems().observe(this, nbaTeamItemsName -> {
            mBinding.rvNbaTeams.setAdapter(new NbaTeamsAdapter(nbaTeamItemsName));
        });

//        nbaTeamItemsName = new ArrayList<>();

//        nbaTeamItemsName.add("Umbra Pryna");
//        nbaTeamItemsName.add("Vayne Aurelius");
//        nbaTeamItemsName.add("The Balladeer");


    }
}