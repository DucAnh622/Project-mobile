package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;
import com.example.doan_10.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.ArrayList;

public class SongPlaylistActivity extends AppCompatActivity implements RecyclerviewSongItemOnClick {
    private RecyclerView top_song;
//    private ArrayList<Song> ListSong;
    private SongAdapter songAdapter;
    private Button back;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playlist);
        prepareSongData();
//        top_song = findViewById(R.id.id_song_playlist);
//        top_song.setLayoutManager(new LinearLayoutManager(SongPlaylistActivity.this));
//        songAdapter = new SongAdapter(SongPlaylistActivity.this,ListSong,this);
//        top_song.setAdapter(songAdapter);

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
    }
    private void prepareSongData() {
//        ListSong = new ArrayList<>();
//        Song song = new Song(R.drawable.slider1, "Nơi này có anh", "Sơn Tùng",R.raw.song1,false);
//        ListSong.add(song);
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

    @Override
    public void onSongItemClick(int position) {
//        Song clickedSong = ListSong.get(position);
//        Intent intent = new Intent(this, ListenActivity.class);
//        intent.putExtra("imageId", clickedSong.getImageId());
//        intent.putExtra("nameSong", clickedSong.getNameSong());
//        intent.putExtra("singer", clickedSong.getSinger());
//        intent.putExtra("file", clickedSong.getFile());
//        intent.putExtra("ListSong",ListSong);
//        intent.putExtra("IndexSong", position);
//        startActivity(intent);
    }
}