package com.example.doan_10.View.FragmentHome;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.doan_10.Adapter.ArtistAdapter;
import com.example.doan_10.Adapter.PlaylistAdapter;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Model.Artist;
import com.example.doan_10.Model.Playlist;
import com.example.doan_10.Model.Song;
import com.example.doan_10.R;
import com.example.doan_10.View.AddSongPlaylistActivity;
import com.example.doan_10.View.HomeActivity;
import com.example.doan_10.View.LoginActivity;
import com.example.doan_10.View.MyPlaylistActivity;
import com.example.doan_10.View.TopArtistActivity;
import com.example.doan_10.View.TopSongActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  View view;
    private RecyclerView top_song, top_artist;
    private ArrayList<Song> ListSong;
    private ArrayList<Artist> ListArtist;
    private SongAdapter songAdapter;
    private ArtistAdapter artistAdapter;
    private ImageSlider slider;

    public Fragment_Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Home newInstance(String param1, String param2) {
        Fragment_Home fragment = new Fragment_Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        prepareSongData();
        prepareArtistData();
        view =inflater.inflate(R.layout.fragment__home, container, false);
        top_song = view.findViewById(R.id.song_top_id);
        top_artist = view.findViewById(R.id.artist_top_id);
        top_artist.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        top_song.setLayoutManager(new LinearLayoutManager(getContext()));
        songAdapter = new SongAdapter(getContext(),ListSong);
        artistAdapter = new ArtistAdapter(getContext(),ListArtist);
        top_song.setAdapter(songAdapter);
        top_artist.setAdapter(artistAdapter);
        slider = view.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.slider1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider5, ScaleTypes.FIT));
        slider.setImageList(slideModels, ScaleTypes.FIT);
        TextView[] textViews = new TextView[2];
        int[] textViewIds = {R.id.Top_songs_id,R.id.Top_Artist_id};
        for (int i = 0; i < textViews.length; i++) {
            textViews[i] = view.findViewById(textViewIds[i]);
            final int index = i;
            textViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (index) {
                        case 0:
                            Intent intent1 = new Intent(getContext(), TopSongActivity.class);
                            startActivity(intent1);
                            break;
                        case 1:
                            Intent intent2 = new Intent(getContext(), TopArtistActivity.class);
                            startActivity(intent2);
                            break;
                    }
                }
            });
        }
        return view;
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

    private void prepareArtistData() {
        ListArtist = new ArrayList<>();
        Artist artist = new Artist(R.drawable.slider1, "Sơn Tùng");
        ListArtist.add(artist);
        artist = new Artist(R.drawable.slider2, "Vũ");
        ListArtist.add(artist);
        artist = new Artist(R.drawable.slider3, "Binz & Đen");
        ListArtist.add(artist);
        artist = new Artist(R.drawable.slider4, "Phương Ly");
        ListArtist.add(artist);
        artist = new Artist(R.drawable.slider5, "Mono");
        ListArtist.add(artist);
    }
}