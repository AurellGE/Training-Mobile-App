package com.severianfw.training_mobile.view.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.severianfw.training_mobile.view.data.remote.ApiConfig;
import com.severianfw.training_mobile.view.data.remote.ApiService;
import com.severianfw.training_mobile.view.data.remote.ResponseItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<ResponseItem>> _nbaTeams = new MutableLiveData<>();
    public LiveData<List<ResponseItem>> getNbaTeamItems() {
//      Sifat LiveData: Tidak bisa diubah, sehingga memerlukan MutableLiveData
        return _nbaTeams;
    }

    private final ApiService mApiService = ApiConfig.getApiService();

    public void callApi() {
        mApiService.getNbaTeams().enqueue(new Callback<List<ResponseItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<ResponseItem>> call, @NonNull Response<List<ResponseItem>> response) {
                if (response.isSuccessful()) {
                    _nbaTeams.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ResponseItem>> call, @NonNull Throwable t) {

            }
        });
    }

}
