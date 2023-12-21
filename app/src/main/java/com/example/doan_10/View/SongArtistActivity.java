package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;
import com.example.doan_10.Model.song.Song;
import com.example.doan_10.R;
import com.example.doan_10.viewmodels.ListSongViewModel;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SongArtistActivity extends AppCompatActivity implements RecyclerviewSongItemOnClick {
    private View view;
    private ListSongViewModel listSongViewModel;
    private RecyclerView top_song;
//    private ArrayList<Song> ListSong;
    private SongAdapter songAdapter;
    private ImageSlider slider;
    private Button back;

    private TextView ArtistName;
    private ImageView ImageArtistId;
    private String nameArtist, imageUrl;
    private Integer idArtist;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_artist);
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
        top_song = findViewById(R.id.song_artist_id);
        top_song.setLayoutManager(new LinearLayoutManager(SongArtistActivity.this));

        ImageArtistId = findViewById(R.id.ImageId);
        ArtistName = findViewById(R.id.Artist_name);
//        ArtistName.setSelected(true);
        Intent intent = getIntent();
        if (intent != null) {
            imageUrl = intent.getStringExtra("imageUrl");
            nameArtist = intent.getStringExtra("nameArtist");
            idArtist = intent.getIntExtra("idArtist", 0);
            ArtistName.setText(nameArtist);
            Picasso.get().load(imageUrl).into(ImageArtistId);
            listSongViewModel = new ViewModelProvider(this).get(ListSongViewModel.class);
            listSongViewModel.getListSongByIdArtist(idArtist).observe(this, list -> {
                List<Song> test = list;
                songAdapter = new SongAdapter(SongArtistActivity.this, list, new RecyclerviewSongItemOnClick() {
                    @Override
                    public void onSongItemClick(int position) {
                        Song song = list.get(position);
                        List<Song> ListSong = list;
                        Intent intent = new Intent(SongArtistActivity.this, ListenActivity.class);
                        intent.putExtra("imageUrl", song.getAvatar());
                        intent.putExtra("nameSong", song.getTitle());
                        intent.putExtra("singer", song.getNameArtist());
                        intent.putExtra("musicUrl", song.getUrlMusic());
                        intent.putExtra("ListSong", (Serializable) list);
                        intent.putExtra("IndexSong", position);
                        startActivity(intent);
                    }
                });
                top_song.setAdapter(songAdapter);
            });
        }
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
