package com.example.doan_10.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.repositories.ListArtistRepository;

import java.util.List;

public class ListArtistViewModel extends AndroidViewModel {
    private ListArtistRepository listArtistRepository;
    public ListArtistViewModel(@NonNull Application application) {
        super(application);
        listArtistRepository = new ListArtistRepository(application);
    }

    public LiveData<List<Artist>> getListArtist(){
        return listArtistRepository.getMutableLiveData();
    }

    public LiveData<List<Artist>> getListArtistSearch(String key){
        return listArtistRepository.getMutableLiveDataSearch(key);
    }
}
