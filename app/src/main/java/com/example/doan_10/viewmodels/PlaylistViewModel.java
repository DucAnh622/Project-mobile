package com.example.doan_10.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.doan_10.Model.playlist.Playlist;
import com.example.doan_10.repositories.PlaylistRepository;

import java.util.List;

public class PlaylistViewModel extends AndroidViewModel {
    private PlaylistRepository playlistRepository;
    public PlaylistViewModel(@NonNull Application application) {
        super(application);
        playlistRepository = new PlaylistRepository(application);
    }
    public LiveData<List<Playlist>> getAllPlaylist(){
        return playlistRepository.getMutableLiveDataAllPlaylist();
    }

    public LiveData<List<Playlist>> getAllPlaylistByUserId(Integer user_id){
        return playlistRepository.getMutableLiveDataAllPlaylistByUserId(user_id);
    }

    public void createPlaylist(String name, Integer userId){
        playlistRepository.createPlaylistByName(name, userId);
    }

    public void addSongToPlaylist(Integer playlist_id, Integer song_id){
        playlistRepository.addSongToPlaylist(playlist_id, song_id);
    }
}
