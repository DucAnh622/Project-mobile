package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;
import com.example.doan_10.R;

import java.util.ArrayList;

public class SongArtistActivity extends AppCompatActivity implements RecyclerviewSongItemOnClick {
    private View view;
    private RecyclerView top_song;
//    private ArrayList<Song> ListSong;
    private SongAdapter songAdapter;
    private ImageSlider slider;
    private Button back;

    private TextView ArtistName;
    private ImageView ImageArtistId;
    private String nameArtist;
    private int imageId;
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
//        top_song = findViewById(R.id.song_artist_id);
//        top_song.setLayoutManager(new LinearLayoutManager(SongArtistActivity.this));
//        songAdapter = new SongAdapter(SongArtistActivity.this,ListSong,this);
//        top_song.setAdapter(songAdapter);
//        ImageArtistId = findViewById(R.id.ImageId);
//        ArtistName = findViewById(R.id.Artist_name);
//        ArtistName.setSelected(true);
        Intent intent = getIntent();
        if (intent != null) {
            imageId = intent.getIntExtra("imageId", 0);
            nameArtist = intent.getStringExtra("nameArtist");
            ImageArtistId.setImageResource(imageId);
            ArtistName.setText(nameArtist);
        }
    }
    private void prepareSongData() {
//        ListSong = new ArrayList<>();
//        Song song = new Song(R.drawable.slider1, "Nơi này có anh", "Sơn Tùng",R.raw.song1,true);
//        ListSong.add(song);
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
