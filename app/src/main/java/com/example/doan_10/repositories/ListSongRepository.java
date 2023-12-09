package com.example.doan_10.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.doan_10.Model.song.ListSong;
import com.example.doan_10.Model.song.Song;
import com.example.doan_10.network.RestApiService;
import com.example.doan_10.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSongRepository {
    private ArrayList<Song> listSong = new ArrayList<>();
    private MutableLiveData<List<Song>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public ListSongRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Song>> getMutableLiveData(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<ListSong> call = apiService.getListSong();
        call.enqueue(new Callback<ListSong>() {
            @Override
            public void onResponse(Call<ListSong> call, Response<ListSong> response) {
                ListSong list = response.body();
                if (list != null && list.getList_song() != null){
                    listSong = (ArrayList<Song>) list.getList_song();
                    mutableLiveData.setValue(listSong.stream().limit(5).collect(Collectors.toList()));
                }
            }

            @Override
            public void onFailure(Call<ListSong> call, Throwable t) {
                Log.d("listsize", "-> Error   " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
