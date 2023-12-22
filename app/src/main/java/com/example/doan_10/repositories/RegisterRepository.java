package com.example.doan_10.repositories;

import com.example.doan_10.network.RestApiService;
import com.example.doan_10.network.RetrofitInstance;

import android.app.Application;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterRepository {
    private Application application;
    public RegisterRepository(Application application) {
        this.application = application;
    }
    public void Register(String firstname, String lastname, String email, String username, String password){

        RestApiService apiService = RetrofitInstance.getApiService();

        Call<Void> call = apiService.register(firstname,lastname,email,username,password);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 201){
                    Log.d("status_create", "successful!");
                }
                Log.d("status_create", "fail!");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
