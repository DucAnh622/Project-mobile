package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.doan_10.Adapter.ArtistAdapter;
import com.example.doan_10.Interface.RecyclerviewArtistItemOnClick;

import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.R;
import com.example.doan_10.viewmodels.ListArtistViewModel;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.ArrayList;
import java.util.List;

public class TopArtistActivity extends AppCompatActivity implements RecyclerviewArtistItemOnClick {
    private Button back;
    private RecyclerView top_artist;
    private ArtistAdapter artistAdapter;
    private ListArtistViewModel listArtistViewModel;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artist);
        progressBar = findViewById(R.id.progressBar);
        Sprite wave = new Wave();
        progressBar.setIndeterminateDrawable(wave);
        top_artist = findViewById(R.id.artist_top);
        top_artist.setLayoutManager(new GridLayoutManager(TopArtistActivity.this, 3));

        listArtistViewModel = new ViewModelProvider(this).get(ListArtistViewModel.class);
        listArtistViewModel.getListArtist().observe(this, listArtist -> {
            List<Artist> list = listArtist;
            artistAdapter = new ArtistAdapter(TopArtistActivity.this, list, new RecyclerviewArtistItemOnClick() {
                @Override
                public void onArtistItemClick(int position) {
                    Artist artist = list.get(position);
                    Intent intent = new Intent(TopArtistActivity.this, SongArtistActivity.class);
                    intent.putExtra("imageUrl", artist.getAvatar());
                    intent.putExtra("nameArtist", artist.getName());
                    intent.putExtra("idArtist", artist.getId());
                    startActivity(intent);
                }
            });
            progressBar.setVisibility(View.GONE);
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
    private void prepareArtistData() {

    }

    @Override
    public void onArtistItemClick(int position) {
//        Artist clickedArtist = ListArtist.get(position);
//        Intent intent = new Intent(this, SongArtistActivity.class);
//        intent.putExtra("imageId", clickedArtist.getImageId());
//        intent.putExtra("nameArtist", clickedArtist.getName());
//        startActivity(intent);
    }

}