package com.example.doan_10.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.doan_10.Model.song.Song;
import com.example.doan_10.repositories.ListSongRepository;

import java.util.List;

public class ListSongViewModel extends AndroidViewModel {
    private ListSongRepository listSongRepository;
    public ListSongViewModel(@NonNull Application application) {
        super(application);
        listSongRepository = new ListSongRepository(application);
    }
    public LiveData<List<Song>> getListSong(){
        return listSongRepository.getMutableLiveData();
    }
    public LiveData<List<Song>> getListSongSearch(String key){
        return listSongRepository.getMutableLiveDataSearch(key);
    }
}
