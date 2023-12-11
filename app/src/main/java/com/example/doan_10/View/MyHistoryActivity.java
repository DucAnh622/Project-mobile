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
import android.widget.Toast;

import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;
import com.example.doan_10.View.FragmentHome.Fragment_Library;

import java.util.ArrayList;

public class MyHistoryActivity extends AppCompatActivity implements RecyclerviewSongItemOnClick {
    private Button back;
    private RecyclerView top_song;
    private ArrayList<Song> ListSong;
    private SongAdapter songAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_history);
        back = findViewById(R.id.BackView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        prepareSongData();
        top_song = findViewById(R.id.id_song_history);
        top_song.setLayoutManager(new LinearLayoutManager(MyHistoryActivity.this));
        songAdapter = new SongAdapter(MyHistoryActivity.this,ListSong,this);
        top_song.setAdapter(songAdapter);
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
        ListSong = new ArrayList<>();
        Song song = new Song(R.drawable.slider1, "Nơi này có anh", "Sơn Tùng",R.raw.song1,true);
        ListSong.add(song);
    }

    @Override
    public void onSongItemClick(int position) {
        Song clickedSong = ListSong.get(position);
        Intent intent = new Intent(this, ListenActivity.class);
        intent.putExtra("imageId", clickedSong.getImageId());
        intent.putExtra("nameSong", clickedSong.getNameSong());
        intent.putExtra("singer", clickedSong.getSinger());
        intent.putExtra("file", clickedSong.getFile());
        intent.putExtra("ListSong",ListSong);
        intent.putExtra("IndexSong", position);
        startActivity(intent);
    }
}