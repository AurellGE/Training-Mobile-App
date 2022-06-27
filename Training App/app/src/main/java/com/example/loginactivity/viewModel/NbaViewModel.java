package com.example.loginactivity.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginactivity.data.remote.ApiConfig;
import com.example.loginactivity.data.remote.ApiService;
import com.example.loginactivity.data.remote.ResponseItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NbaViewModel extends ViewModel {

    private MutableLiveData<List<ResponseItem>> _nbaTeams = new MutableLiveData<>();
    public LiveData<List<ResponseItem>> getNbaTeamItems() {
        return _nbaTeams;
    }

    private final ApiService mApiService = ApiConfig.getApiService();

    public void callApi() {
        mApiService.getNbaTeams().enqueue(new Callback<List<ResponseItem>>() {
            @Override
            public void onResponse(Call<List<ResponseItem>> call, Response<List<ResponseItem>> response) {
                if (response.isSuccessful()) {
                    _nbaTeams.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ResponseItem>> call, Throwable t) {

            }
        });
    }
}
