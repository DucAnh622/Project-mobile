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
import android.widget.Toast;

import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;

import com.example.doan_10.R;
import com.example.doan_10.View.FragmentHome.Fragment_Library;
import com.example.doan_10.viewmodels.ListSongViewModel;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity implements RecyclerviewSongItemOnClick {
    private Button back;
    private RecyclerView top_song;
    private SongAdapter songAdapter;
    private ListSongViewModel listSongViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);
        back = findViewById(R.id.BackView);
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
            songAdapter = new SongAdapter(AllSongsActivity.this, list, this);
            top_song.setAdapter(songAdapter);
        });
    }


    @Override
    public void onSongItemClick(int position) {

    }
}