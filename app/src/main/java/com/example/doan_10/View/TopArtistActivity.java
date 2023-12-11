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

import com.example.doan_10.Adapter.ArtistAdapter;
import com.example.doan_10.Interface.RecyclerviewArtistItemOnClick;

import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.R;
import com.example.doan_10.viewmodels.ListArtistViewModel;

import java.util.ArrayList;
import java.util.List;

public class TopArtistActivity extends AppCompatActivity implements RecyclerviewArtistItemOnClick {
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
            artistAdapter = new ArtistAdapter(TopArtistActivity.this, list, this);
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