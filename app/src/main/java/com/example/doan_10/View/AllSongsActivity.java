package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Adapter.SongPlaylistAdapter;
import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;

import com.example.doan_10.R;
import com.example.doan_10.View.FragmentHome.Fragment_Library;
import com.example.doan_10.viewmodels.ListSongViewModel;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity implements RecyclerviewSongItemOnClick {
    private Button back;
    private RecyclerView top_song;
    private SongPlaylistAdapter songPlaylistAdapter;
    private ListSongViewModel listSongViewModel;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);
        back = findViewById(R.id.BackView);
        progressBar = findViewById(R.id.progressBar);
        Sprite wave = new Wave();
        progressBar.setIndeterminateDrawable(wave);
        progressBar.setVisibility(View.GONE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        top_song = findViewById(R.id.id_all_song);
        top_song.setLayoutManager(new LinearLayoutManager(AllSongsActivity.this));
        prepareSongData();
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
    private void prepareSongData() {
        listSongViewModel = new ViewModelProvider(this).get(ListSongViewModel.class);
        listSongViewModel.getListSong().observe(this, list -> {
            songPlaylistAdapter = new SongPlaylistAdapter(AllSongsActivity.this, list, this);
            top_song.setAdapter(songPlaylistAdapter);
        });
    }


    @Override
    public void onSongItemClick(int position) {

    }
}