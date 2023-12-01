package com.example.doan_10.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan_10.Model.Playlist;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;

import java.util.ArrayList;

public class PlaylistAdapter extends  RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {
    private ArrayList<Playlist> Playlists;
    private Context context;
    public PlaylistAdapter(Context context, ArrayList<Playlist> Playlists) {
        this.Playlists = Playlists;
        this.context = context;
    }
    @NonNull
    @Override
    public PlaylistAdapter.PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item, parent, false);
        return new PlaylistAdapter.PlaylistViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.PlaylistViewHolder holder, int position) {
        Playlist playList = Playlists.get(position);
        if (playList == null) {
            return;
        }
        holder.namePlaylist.setText(getEllipsizedText(playList.getName(), holder.namePlaylist));
    }

    public class PlaylistViewHolder extends RecyclerView.ViewHolder {
        private TextView namePlaylist;

        public PlaylistViewHolder(@NonNull View itemView) {
            super(itemView);
            namePlaylist = itemView.findViewById(R.id.playlist_name_id);
        }
    }
    @Override
    public int getItemCount() {
        if (Playlists != null && Playlists.size() > 0)
            return Playlists.size();
        else
            return 0;
    }
    private String getEllipsizedText(String text, TextView textView) {
        int maxLength = 20;
        if (text.length() > maxLength) {
            String ellipsizedText = text.substring(0, maxLength - 3) + "...";
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setMaxLines(1);
            return ellipsizedText;
        } else {
            return text;
        }
    }
}
