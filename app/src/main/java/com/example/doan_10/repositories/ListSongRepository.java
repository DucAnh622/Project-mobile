package com.example.doan_10.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.Model.search.Search;
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

    public MutableLiveData<List<Song>> getMutableLiveDataSearch(String key){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<Search> call = apiService.getResultSearch(key);
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                Search search = response.body();
                if (search != null && search.getSongs() != null){
                    listSong = (ArrayList<Song>) search.getSongs();
                    mutableLiveData.setValue(listSong);
                }
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                Log.d("listsize", "-> Error   " + t.getMessage());
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<List<Song>> getMutableLiveDataByIdArtist(int id_artist){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<ListSong> call = apiService.getSongByIdArtist(id_artist);
        call.enqueue(new Callback<ListSong>() {
            @Override
            public void onResponse(Call<ListSong> call, Response<ListSong> response) {
                ListSong list = response.body();
                if (list != null && list.getList_song() != null){
                    listSong = (ArrayList<Song>) list.getList_song();
                    mutableLiveData.setValue(listSong);
                }
            }

            @Override
            public void onFailure(Call<ListSong> call, Throwable t) {
                Log.d("listsize", "-> Error   " + t.getMessage());
                Log.e("phuc", "load xit roi");
            }
        });
        return mutableLiveData;
    }
}
