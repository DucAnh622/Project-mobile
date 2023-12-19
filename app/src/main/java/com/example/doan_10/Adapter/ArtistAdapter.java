package com.example.doan_10.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.doan_10.Interface.RecyclerviewArtistItemOnClick;
import com.example.doan_10.Model.artists.Artist;
import com.example.doan_10.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {

    private final RecyclerviewArtistItemOnClick recyclerviewArtistItemOnClick;

    private List<Artist> ListArtist;

    private Context context;

    public ArtistAdapter(Context context, List<Artist> ListArtist, RecyclerviewArtistItemOnClick recyclerviewArtistItemOnClick) {
        this.ListArtist = ListArtist;
        this.context = context;
        this.recyclerviewArtistItemOnClick = recyclerviewArtistItemOnClick;
    }

    @NonNull
    @Override
    public ArtistAdapter.ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_2, parent, false);
        return new ArtistAdapter.ArtistViewHolder(view, recyclerviewArtistItemOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapter.ArtistViewHolder holder, int position) {
        Artist artist = ListArtist.get(position);
        if (artist == null) {
            return;
        }
        String urlImage = artist.getAvatar();
        Picasso.get().load(urlImage).into(holder.imageArtist);
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

        public ArtistViewHolder(@NonNull View itemView, RecyclerviewArtistItemOnClick recyclerviewArtistItemOnClick) {
            super(itemView);
            imageArtist = itemView.findViewById(R.id.ImageId);
            nameArtist = itemView.findViewById(R.id.artist_id);
            nameArtist.setSelected(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerviewArtistItemOnClick != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            recyclerviewArtistItemOnClick.onArtistItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
