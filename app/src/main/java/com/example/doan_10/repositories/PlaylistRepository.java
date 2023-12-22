package com.example.doan_10.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.doan_10.Model.playlist.Playlist;
import com.example.doan_10.network.RestApiService;
import com.example.doan_10.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistRepository {
    private Playlist playlist;
    private List<Playlist> playlists;
    private MutableLiveData<List<Playlist>> mutableLiveDataListPlaylist = new MutableLiveData<>();
    private Application application;

    public PlaylistRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Playlist>> getMutableLiveDataAllPlaylist(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<Playlist>> call = apiService.getAllPlaylist();
        call.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                List<Playlist> playlistList = response.body();
                if (playlistList != null){
                    playlists = playlistList;
                    mutableLiveDataListPlaylist.setValue(playlists);
                }
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                Log.d("listsize", "-> Error   " + t.getMessage());
            }
        });
        return mutableLiveDataListPlaylist;
    }

    public MutableLiveData<List<Playlist>> getMutableLiveDataAllPlaylistByUserId(int user_id){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<Playlist>> call = apiService.getPlaylistByUserId(user_id);
        call.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                List<Playlist> playlistList = response.body();
                if (playlistList != null){
                    playlists = playlistList;
                    mutableLiveDataListPlaylist.setValue(playlists);
                }
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                Log.d("listsize", "-> Error   " + t.getMessage());
            }
        });
        return mutableLiveDataListPlaylist;
    }

    public void createPlaylistByName(String name, int userId){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<Void> call = apiService.creatPlaylist(name, userId);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("status", "created playlist");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("status", "fail!");
            }
        });
    }

    public void addSongToPlaylist(Integer playlist_id, Integer song_id){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<Void> call = apiService.addSongToPlaylist(playlist_id, song_id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("status_add_song", "add song to playlist successful");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
