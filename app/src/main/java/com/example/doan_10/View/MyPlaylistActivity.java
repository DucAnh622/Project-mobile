package com.example.doan_10.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doan_10.Adapter.PlaylistAdapter;
import com.example.doan_10.Model.Playlist;
import com.example.doan_10.R;
import com.example.doan_10.viewmodels.PlaylistViewModel;

import java.util.ArrayList;

public class MyPlaylistActivity extends AppCompatActivity {
    private Button back, AddPlaylist;
    private RecyclerView my_playlist;
    private ArrayList<Playlist> Playlists;
    private PlaylistAdapter playlistAdapter;
    private PlaylistViewModel playlistViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_playlist);
        back = findViewById(R.id.BackView);
        AddPlaylist = findViewById(R.id.AddPlaylist);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        AddPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showModal(Gravity.CENTER);
            }
        });
        my_playlist = findViewById(R.id.id_item_playlist);
        my_playlist.setLayoutManager(new LinearLayoutManager(MyPlaylistActivity.this));
        preparePlaylistData();

    }
    private void preparePlaylistData() {
        playlistViewModel = new ViewModelProvider(this).get(PlaylistViewModel.class);
        playlistViewModel.getAllPlaylist().observe(this, playlists -> {
            playlistAdapter = new PlaylistAdapter(MyPlaylistActivity.this, playlists);
            my_playlist.setAdapter(playlistAdapter);
            playlistAdapter.notifyDataSetChanged();
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

    private void showModal(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_add_playlist);
        Window window = dialog.getWindow();
        if(window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        dialog.setCancelable(true);

        EditText playlist_name = dialog.findViewById(R.id.playlist_name);
        Button cancel = dialog.findViewById(R.id.CancelButton);
        Button submit = dialog.findViewById(R.id.SubmitButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                playlist_name.setText("");
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_playlist = playlist_name.getText().toString();
                if (name_playlist.isEmpty()) {
                    Toast.makeText(MyPlaylistActivity.this, "Invalid input!", Toast.LENGTH_SHORT).show();
                }
                else {
                    playlistViewModel = new ViewModelProvider(MyPlaylistActivity.this).get(PlaylistViewModel.class);
                    playlistViewModel.createPlaylist(name_playlist, 1);
                    Toast.makeText(MyPlaylistActivity.this, "Created playlist "+name_playlist, Toast.LENGTH_SHORT).show();
                    preparePlaylistData();
                    dialog.dismiss();
                }
                playlist_name.setText("");
            }
        });

        dialog.show();
    }
}