package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doan_10.Adapter.PlaylistAdapter;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Model.Playlist;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;
import com.example.doan_10.View.FragmentHome.Fragment_Library;

import java.util.ArrayList;

public class MyPlaylistActivity extends AppCompatActivity {
    private Button back, AddPlaylist;
    private RecyclerView my_playlist;
    private ArrayList<Playlist> Playlists;
    private PlaylistAdapter playlistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_playlist);
        back = findViewById(R.id.BackView);
        AddPlaylist = findViewById(R.id.AddPlaylist);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        AddPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPlaylistActivity.this,AddPlaylistActivity.class);
                startActivity(intent);
                finish();
            }
        });
        prepareSongData();
        my_playlist = findViewById(R.id.id_item_playlist);
        my_playlist.setLayoutManager(new LinearLayoutManager(MyPlaylistActivity.this));
        playlistAdapter = new PlaylistAdapter(MyPlaylistActivity.this,Playlists);
        my_playlist.setAdapter(playlistAdapter);
    }
    private void prepareSongData() {
        Playlists = new ArrayList<>();
        Playlist playlist = new Playlist("My album 01");
        Playlists.add(playlist);
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