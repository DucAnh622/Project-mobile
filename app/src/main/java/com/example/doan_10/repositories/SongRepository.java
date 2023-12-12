package com.example.doan_10.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.doan_10.Model.song.Song;
import com.example.doan_10.network.RestApiService;
import com.example.doan_10.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongRepository {
    private Song song;
    private MutableLiveData<Song> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public SongRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<Song> getMutableLiveData(int id){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<Song> call = apiService.getSongById(id);
        call.enqueue(new Callback<Song>() {
            @Override
            public void onResponse(Call<Song> call, Response<Song> response) {
                Song rs_song = response.body();
                if (rs_song != null){
                    song = (Song) rs_song;
                    mutableLiveData.setValue(song);
                }
            }

            @Override
            public void onFailure(Call<Song> call, Throwable t) {
                Log.d("listsize", "-> Error   " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
