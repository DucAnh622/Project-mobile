package com.example.doan_10.network;

import com.example.doan_10.Model.artists.ListArtist;
import com.example.doan_10.Model.playlist.Playlist;
import com.example.doan_10.Model.search.Search;
import com.example.doan_10.Model.song.ListSong;
import com.example.doan_10.Model.song.Song;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    @GET("song/artist_id/{id_artist}")
    Call<ListSong> getSongByIdArtist(@Path("id_artist") int id_artist);
    @GET("playlist")
    Call<List<Playlist>> getAllPlaylist();
    @FormUrlEncoded
    @POST("playlist/create")
    Call<String> creatPlaylist(@Field("name") String name, @Field("user_id") int user_id);

    @FormUrlEncoded
    @POST("register")
    Call<String> register(
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login")
    Call<String> login(
            @Field("username") String username,
            @Field("password") String password
    );
    @GET("song/playlist_id/{id_playlist}")
    Call<ListSong> getSongByIdPlaylist(@Path("id_playlist") int id_playlist);

}
