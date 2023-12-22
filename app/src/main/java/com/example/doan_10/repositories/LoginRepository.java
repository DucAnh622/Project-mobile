package com.example.doan_10.repositories;

import com.example.doan_10.network.RestApiService;
import com.example.doan_10.network.RetrofitInstance;

import android.app.Application;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private Application application;

    public LoginRepository(Application application) {
        this.application = application;
    }
    public void Login(String username, String password){

        RestApiService apiService = RetrofitInstance.getApiService();

        Call<Void> call = apiService.login(username,password);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200){
                    Log.d("status_create", "successful!");
                }
                else {
                    Log.d("status_create", "fail!");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
