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

        Call<String> call = apiService.login(username,password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() && response.code() == 200){
                    String rs = response.body();
                    Log.d("status_create", rs);
                }
                Log.d("status_create", "fail!");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("status_connect", "fail");
            }
        });
    }
}
