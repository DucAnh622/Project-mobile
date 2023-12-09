package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;
import com.example.doan_10.viewmodels.ListSongViewModel;

import java.util.ArrayList;

public class TopSongActivity extends AppCompatActivity {
    private Button back;
    private RecyclerView top_song;
    private ArrayList<Song> ListSong;
    private SongAdapter songAdapter;
    private ListSongViewModel listSongViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_song);
        back = findViewById(R.id.BackView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        prepareSongData();
        top_song = findViewById(R.id.song_top);
        top_song.setLayoutManager(new LinearLayoutManager(TopSongActivity.this));
        listSongViewModel = new ViewModelProvider(this).get(ListSongViewModel.class);
        listSongViewModel.getListSong().observe(this, list ->{
            songAdapter = new SongAdapter(TopSongActivity.this, list);
            top_song.setAdapter(songAdapter);
        });

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
        Song song = new Song(R.drawable.slider1, "Nơi này có anh", "Sơn Tùng",true);

        ListSong.add(song);

        song = new Song(R.drawable.slider2, "Bước qua nhau", "Vũ",true);
        ListSong.add(song);

        song = new Song(R.drawable.slider3, "Cho  mình em", "Binz ft Đen",true);
        ListSong.add(song);

        song = new Song(R.drawable.slider4, "Anh là ngoại lệ của em", "Phương Ly",true);
        ListSong.add(song);

        song = new Song(R.drawable.slider5, "Waiting for you", "Mono",true);
        ListSong.add(song);
    }
}