package com.example.doan_10.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.Model.artists.ListArtist;
import com.example.doan_10.Model.search.Search;
import com.example.doan_10.network.RestApiService;
import com.example.doan_10.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListArtistRepository {
    private ArrayList<Artist> listArtist = new ArrayList<>();
    private MutableLiveData<List<Artist>> mutableLiveData =new MutableLiveData<>();
    private Application application;

    public ListArtistRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Artist>> getMutableLiveData(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<ListArtist> call = apiService.getListArtist();
        call.enqueue(new Callback<ListArtist>() {
            @Override
            public void onResponse(Call<ListArtist> call, Response<ListArtist> response) {
                ListArtist list = response.body();
                if (list != null && list.getListArtist() != null){
                    listArtist = (ArrayList<Artist>) list.getListArtist();
                    mutableLiveData.setValue(listArtist);
                }
            }

            @Override
            public void onFailure(Call<ListArtist> call, Throwable t) {
                Log.d("listsize", "-> Error   " + t.getMessage());
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<List<Artist>> getMutableLiveDataSearch(String key){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<Search> call = apiService.getResultSearch(key);
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                Search search = response.body();
                if (search != null && search.getArtists() != null){
                    listArtist = (ArrayList<Artist>) search.getArtists();
                    mutableLiveData.setValue(listArtist);
                }
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                Log.d("listsize", "-> Error   " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
