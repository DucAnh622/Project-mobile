package com.example.doan_10.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;
import com.example.doan_10.Model.song.Song;
import com.example.doan_10.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongPlaylistAdapter extends RecyclerView.Adapter<SongPlaylistAdapter.SongPlaylistViewHolder> {
    private final RecyclerviewSongItemOnClick recyclerviewSongItemOnClick;

    private List<Song> ListSong;

    private Context context;

    public SongPlaylistAdapter(Context context, List<Song> ListSong, RecyclerviewSongItemOnClick recyclerviewSongItemOnClick) {
        this.ListSong = ListSong;
        this.context = context;
        this.recyclerviewSongItemOnClick = recyclerviewSongItemOnClick;
    }

    @NonNull
    @Override
    public SongPlaylistAdapter.SongPlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_3, parent, false);
        return new SongPlaylistViewHolder(view, recyclerviewSongItemOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull SongPlaylistAdapter.SongPlaylistViewHolder holder, int position) {
        Song song = ListSong.get(position);
        if (song == null) {
            return;
        }
        holder.nameSong.setText(song.getTitle());
        String urlAvatar = song.getAvatar();
        Picasso.get().load(urlAvatar).into(holder.imageSong);
        holder.singer.setText(song.getNameArtist());
    }

    @Override
    public int getItemCount() {
        if (ListSong != null && ListSong.size() > 0)
            return ListSong.size();
        else
            return 0;
    }

    public class SongPlaylistViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageSong;
        private TextView nameSong, singer;

        private Button add, remove;
        public SongPlaylistViewHolder (@NonNull View itemView, RecyclerviewSongItemOnClick recyclerviewSongItemOnClick) {
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
    }
}
