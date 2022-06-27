package com.example.session5;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public String result;

    public void sum(int num1, int num2) {
        int resultNum = num1 + num2;
        result = Integer.toString(resultNum);
    }
}
