package com.severianfw.training_mobile.view.data.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("nbateams")
    Call<List<ResponseItem>> getNbaTeams();
}
