package com.example.doan_10.network;

import com.example.doan_10.Model.artists.ListArtist;
import com.example.doan_10.Model.search.Search;
import com.example.doan_10.Model.song.ListSong;
import com.example.doan_10.Model.song.Song;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApiService {
    @GET("artist")
    Call<ListArtist> getListArtist();
    @GET("song")
    Call<ListSong> getListSong();
    @GET("search")
    Call<Search> getResultSearch(@Query("q") String q);
    @GET("song/{id}")
    Call<Song> getSongById(@Path("id") int id);
}
