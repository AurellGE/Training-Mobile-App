package com.example.session5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.session5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private  MainViewModel mMainViewModel;
    private ActivityMainBinding mBinding;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


//        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mBinding.btnAdd.setOnClickListener(view -> {
            int num1 = Integer.parseInt(mBinding.etNum1.getText().toString());
            int num2 = Integer.parseInt(mBinding.etNum2.getText().toString());

//            mMainViewModel.sum(num1, num2);

            int resultInt = num1 + num2;
            result = Integer.toString(resultInt);
            mBinding.tvResult.setText(result);
        });

//        mBinding.tvResult.setText(mMainViewModel.result);

        if (savedInstanceState != null) {
            result = savedInstanceState.getString("RESULT_KEY");
            mBinding.tvResult.setText(result);
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString("RESULT_KEY", result);
        super.onSaveInstanceState(outState);
    }
}