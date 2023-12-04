package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doan_10.Adapter.ArtistAdapter;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Model.Artist;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;

import java.util.ArrayList;

public class TopArtistActivity extends AppCompatActivity {
    private Button back;
    private RecyclerView top_artist;
    private ArrayList<Artist> ListArtist;
    private ArtistAdapter artistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artist);
        prepareArtistData();
        top_artist = findViewById(R.id.artist_top);
        top_artist.setLayoutManager(new GridLayoutManager(TopArtistActivity.this, 3));
        artistAdapter = new ArtistAdapter(TopArtistActivity.this,ListArtist);
        top_artist.setAdapter(artistAdapter);
        back = findViewById(R.id.BackView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void prepareArtistData() {
        ListArtist = new ArrayList<>();
        Artist artist = new Artist(R.drawable.slider1, "Sơn Tùng");
        ListArtist.add(artist);
        artist = new Artist(R.drawable.slider2, "Vũ");
        ListArtist.add(artist);
        artist = new Artist(R.drawable.slider3, "Binz & Đen");
        ListArtist.add(artist);
        artist = new Artist(R.drawable.slider4, "Phương Ly");
        ListArtist.add(artist);
        artist = new Artist(R.drawable.slider5, "Mono");
        ListArtist.add(artist);
    }
}