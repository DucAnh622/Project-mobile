package com.example.doan_10.Adapter;

import android.content.Context;
import android.text.TextUtils;
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

import com.example.doan_10.Model.Playlist;
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
        holder.bind(playList);
    }

    public class PlaylistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
        private TextView namePlaylist;
        private CheckBox checkbox;

        private Button setting;

        public PlaylistViewHolder(@NonNull View itemView) {
            super(itemView);
            namePlaylist = itemView.findViewById(R.id.playlist_name_id);
            checkbox = itemView.findViewById(R.id.type_checkbox);
            setting = itemView.findViewById(R.id.setting_playlist);
            setting.setOnClickListener(this);
        }

        public void bind(Playlist playlist) {
            if (playlist.getCheck()) {
                checkbox.setVisibility(View.VISIBLE);
                setting.setVisibility(View.GONE);
            } else {
                checkbox.setVisibility(View.GONE);
                setting.setVisibility(View.VISIBLE);
            }
            namePlaylist.setText(getEllipsizedText(playlist.getName(), namePlaylist));
        }

        @Override
        public void onClick(View v) {
            showSetting(v);
            int position = getAbsoluteAdapterPosition()+1;
            Toast.makeText(v.getContext(), "Item at position " + position + " clicked", Toast.LENGTH_SHORT).show();
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
