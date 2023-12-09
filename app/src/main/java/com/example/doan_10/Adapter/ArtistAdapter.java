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

import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {
    private List<Artist> ListArtist;

    private Context context;

    public ArtistAdapter(Context context, List<Artist> ListArtist) {
        this.ListArtist = ListArtist;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtistAdapter.ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_2, parent, false);
        return new ArtistAdapter.ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapter.ArtistViewHolder holder, int position) {
        Artist artist = ListArtist.get(position);
        if (artist == null) {
            return;
        }
        String urlImage = artist.getAvatar();
        Picasso.get().load(urlImage).into(holder.imageArtist);
        holder.nameArtist.setText(getEllipsizedText(artist.getName(), holder.nameArtist));
    }

    @Override
    public int getItemCount() {
        if (ListArtist != null && ListArtist.size() > 0)
            return ListArtist.size();
        else
            return 0;
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageArtist;
        private TextView nameArtist;

        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);
            imageArtist = itemView.findViewById(R.id.ImageId);
            nameArtist = itemView.findViewById(R.id.artist_id);
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
