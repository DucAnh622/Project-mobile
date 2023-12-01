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

import com.example.doan_10.Model.Song;
import com.example.doan_10.R;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private ArrayList<Song> ListSong;

    private Context context;

    public SongAdapter(Context context, ArrayList<Song> ListSong) {
        this.ListSong = ListSong;
        this.context = context;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_1, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = ListSong.get(position);
        if (song == null) {
            return;
        }
        holder.imageSong.setImageResource(song.getImageId());
        holder.nameSong.setText(getEllipsizedText(song.getNameSong(), holder.nameSong));
        holder.singer.setText(getEllipsizedText(song.getSinger(), holder.singer));
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

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            imageSong = itemView.findViewById(R.id.ImageId);
            nameSong = itemView.findViewById(R.id.song_id);
            singer = itemView.findViewById(R.id.singer_id);
        }
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
