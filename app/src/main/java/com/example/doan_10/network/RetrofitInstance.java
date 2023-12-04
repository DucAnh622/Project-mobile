package com.example.doan_10.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static Retrofit retrofit = null;
    public static RestApiService getApiService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api-music-group-ae-env.eba-rja4mptm.ap-southeast-2.elasticbeanstalk.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RestApiService.class);
    }
}
