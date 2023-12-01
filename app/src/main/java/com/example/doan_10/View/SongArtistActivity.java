package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.doan_10.Adapter.ArtistAdapter;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Model.Artist;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;

import java.util.ArrayList;

public class SongArtistActivity extends AppCompatActivity {
    private View view;
    private RecyclerView top_song;
    private ArrayList<Song> ListSong;
    private SongAdapter songAdapter;
    private ImageSlider slider;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_artist);
        prepareSongData();
        back = findViewById(R.id.BackView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        top_song = findViewById(R.id.song_artist_id);
        top_song.setLayoutManager(new LinearLayoutManager(SongArtistActivity.this));
        songAdapter = new SongAdapter(SongArtistActivity.this,ListSong);
        top_song.setAdapter(songAdapter);
    }
    private void prepareSongData() {
        ListSong = new ArrayList<>();
        Song song = new Song(R.drawable.slider1, "Nơi này có anh", "Sơn Tùng");
        ListSong.add(song);
    }
    @Override
    public void onBackPressed() {
        // Tạo intent để quay trở lại Fragment Library
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("selected_fragment", "home");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}
