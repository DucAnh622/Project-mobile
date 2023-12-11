package com.example.doan_10.Adapter;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;
import com.example.doan_10.Model.Playlist;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private ArrayList<Song> ListSong;
    private final RecyclerviewSongItemOnClick recyclerviewSongItemOnClick;

    private Context context;

    public SongAdapter(Context context, ArrayList<Song> ListSong, RecyclerviewSongItemOnClick recyclerviewSongItemOnClick) {
        this.ListSong = ListSong;
        this.context = context;
        this.recyclerviewSongItemOnClick = recyclerviewSongItemOnClick;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_1, parent, false);
        return new SongViewHolder(view, recyclerviewSongItemOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = ListSong.get(position);
        if (song == null) {
            return;
        }
        holder.bind(song);
    }

    @Override
    public int getItemCount() {
        if (ListSong != null && ListSong.size() > 0)
            return ListSong.size();
        else
            return 0;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageSong;
        private TextView nameSong, singer;

        private Button add, remove;

        public SongViewHolder(@NonNull View itemView, RecyclerviewSongItemOnClick recyclerviewSongItemOnClick) {
            super(itemView);
            imageSong = itemView.findViewById(R.id.ImageId);
            nameSong = itemView.findViewById(R.id.song_id);
            singer = itemView.findViewById(R.id.singer_id);
            nameSong.setSelected(true);
            singer.setSelected(true);
            add = itemView.findViewById(R.id.add_playlist);
            remove = itemView.findViewById(R.id.remove_playlist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerviewSongItemOnClick != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            recyclerviewSongItemOnClick.onSongItemClick(position);
                        }
                    }
                }
            });
        }

        public void bind(Song song) {
            if (song.getCheck()) {
                add.setVisibility(View.VISIBLE);
                remove.setVisibility(View.GONE);
            } else {
                add.setVisibility(View.GONE);
                remove.setVisibility(View.VISIBLE);
            }
            nameSong.setText(song.getNameSong());
            singer.setText(song.getSinger());
            imageSong.setImageResource(song.getImageId());
        }
    }
}
