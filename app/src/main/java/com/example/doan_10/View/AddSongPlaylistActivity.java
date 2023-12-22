package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.doan_10.Adapter.PlaylistAdapter;
import com.example.doan_10.Interface.RecyclerviewPlaylistItemOnClick;
import com.example.doan_10.Model.Playlist;
import com.example.doan_10.R;
import com.example.doan_10.viewmodels.PlaylistViewModel;

import java.util.ArrayList;

public class AddSongPlaylistActivity extends AppCompatActivity {
    private Button back, addPlaylist;
    private RecyclerView my_playlist;
    private ArrayList<Playlist> Playlists;
    private PlaylistAdapter playlistAdapter;
    private PlaylistViewModel playlistViewModel;
    private Integer id_user;
    private Integer id_song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song_playlist);
        back = findViewById(R.id.BackView);
        addPlaylist = findViewById(R.id.addCheck);
        SharedPreferences sharedPreferences = getSharedPreferences("IdUser", Context.MODE_PRIVATE);
        id_user = sharedPreferences.getInt("id_user", 0);
        Intent intent = getIntent();
        if (intent != null){
            id_song = intent.getIntExtra("idSong", 0);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        addPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        my_playlist = findViewById(R.id.check_add_song);
        my_playlist.setLayoutManager(new LinearLayoutManager(AddSongPlaylistActivity.this));
        preparePlaylistData();


    }

    private void preparePlaylistData() {
        playlistViewModel = new ViewModelProvider(this).get(PlaylistViewModel.class);
        playlistViewModel.getAllPlaylistByUserId(id_user).observe(this, playlists -> {
            playlistAdapter = new PlaylistAdapter(AddSongPlaylistActivity.this, playlists, new RecyclerviewPlaylistItemOnClick() {
                @Override
                public void onPlaylistItemClick(int position) {
                    playlistViewModel.addSongToPlaylist(playlists.get(position).getId(), id_song);
                    Toast.makeText(AddSongPlaylistActivity.this, "Add success full!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddSongPlaylistActivity.this, ListenActivity.class);
                    intent.putExtra("selected_fragment", "library");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                }
            });
            my_playlist.setAdapter(playlistAdapter);

        });
    }
    @Override
    public void onBackPressed() {
        // Tạo intent để quay trở lại Fragment Library
        super.onBackPressed();
        Intent intent = new Intent(this, ListenActivity.class);
        intent.putExtra("selected_fragment", "library");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}