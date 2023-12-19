package com.example.doan_10.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.doan_10.Model.song.Song;
import com.example.doan_10.repositories.SongRepository;

public class SongViewModel extends AndroidViewModel {
    private SongRepository songRepository;
    public SongViewModel(@NonNull Application application) {
        super(application);
        this.songRepository = new SongRepository(application);
    }

    public LiveData<Song> getSongById(int id){
        return songRepository.getMutableLiveData(id);
    }
}
