package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doan_10.Adapter.ArtistAdapter;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Model.Song;
import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.R;
import com.example.doan_10.viewmodels.ListArtistViewModel;

import java.util.ArrayList;
import java.util.List;

public class TopArtistActivity extends AppCompatActivity {
    private Button back;
    private RecyclerView top_artist;
    private ArtistAdapter artistAdapter;
    private ListArtistViewModel listArtistViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artist);
        top_artist = findViewById(R.id.artist_top);
        top_artist.setLayoutManager(new GridLayoutManager(TopArtistActivity.this, 3));
        listArtistViewModel = new ViewModelProvider(this).get(ListArtistViewModel.class);
        listArtistViewModel.getListArtist().observe(this, listArtist -> {
            List<Artist> list = listArtist;
            artistAdapter = new ArtistAdapter(TopArtistActivity.this, list);
            top_artist.setAdapter(artistAdapter);
        });


        back = findViewById(R.id.BackView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}