package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doan_10.Adapter.PlaylistAdapter;
import com.example.doan_10.Model.Playlist;
import com.example.doan_10.R;

import java.util.ArrayList;

public class AddSongPlaylistActivity extends AppCompatActivity {
    private Button back, addPlaylist;
    private RecyclerView my_playlist;
    private ArrayList<Playlist> Playlists;
    private PlaylistAdapter playlistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song_playlist);
        back = findViewById(R.id.BackView);
        addPlaylist = findViewById(R.id.addCheck);
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

//        preparePlaylistData();
//        my_playlist = findViewById(R.id.check_add_song);
//        my_playlist.setLayoutManager(new LinearLayoutManager(AddSongPlaylistActivity.this));
//        playlistAdapter = new PlaylistAdapter(AddSongPlaylistActivity.this,Playlists);
//        my_playlist.setAdapter(playlistAdapter);
    }

    private void preparePlaylistData() {
        Playlists = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String playlistName = "My album " + i;
            Playlist playlist = new Playlist(playlistName, true);
            Playlists.add(playlist);
        }
    }
    @Override
    public void onBackPressed() {
        // Tạo intent để quay trở lại Fragment Library
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("selected_fragment", "library");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}