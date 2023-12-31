package com.example.doan_10.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan_10.Interface.RecyclerviewPlaylistItemOnClick;
import com.example.doan_10.Model.playlist.Playlist;
import com.example.doan_10.R;

import java.util.ArrayList;
import java.util.List;

public class PlaylistAdapter extends  RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {
    private List<Playlist> playlists;
    private Context context;
    private RecyclerviewPlaylistItemOnClick recyclerviewPlaylistItemOnClick;
    public PlaylistAdapter(Context context, List<Playlist> playlists, RecyclerviewPlaylistItemOnClick recyclerviewPlaylistItemOnClick) {
        this.playlists = playlists;
        this.context = context;
        this.recyclerviewPlaylistItemOnClick = recyclerviewPlaylistItemOnClick;
    }
    @NonNull
    @Override
    public PlaylistAdapter.PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item, parent, false);
        return new PlaylistAdapter.PlaylistViewHolder(view, recyclerviewPlaylistItemOnClick);
    }
    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.PlaylistViewHolder holder, int position) {
        Playlist playList = playlists.get(position);
        if (playList == null) {
            return;
        }
        holder.bind(playList);
    }

    @Override
    public int getItemCount() {
        if (playlists != null && playlists.size() > 0)
            return playlists.size();
        else
            return 0;
    }

    public class PlaylistViewHolder extends RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener {
        private TextView namePlaylist;

        private Button setting;

        public PlaylistViewHolder(@NonNull View itemView, RecyclerviewPlaylistItemOnClick recyclerviewPlaylistItemOnClick) {
            super(itemView);
            namePlaylist = itemView.findViewById(R.id.playlist_name_id);
            namePlaylist.setSelected(true);
            setting = itemView.findViewById(R.id.setting_playlist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerviewPlaylistItemOnClick != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            recyclerviewPlaylistItemOnClick.onPlaylistItemClick(position);
                        }
                    }
                }
            });
        }

        public void bind(Playlist playlist) {
//            if (playlist.getCheck()) {
//            } else {
//                checkbox.setVisibility(View.GONE);
                setting.setVisibility(View.VISIBLE);
//            }
            namePlaylist.setText(playlist.getName());
        }

        private void showSetting(View view) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.playlist_setting);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            int id = item.getItemId();
            if(id == R.id.playlist_edit) {
                Toast.makeText(itemView.getContext(), "Edit clicked", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.playlist_delete) {
                Toast.makeText(itemView.getContext(), "Delete clicked", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }

}
