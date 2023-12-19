package com.example.doan_10.View.FragmentHome;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.doan_10.Adapter.ArtistAdapter;
import com.example.doan_10.Adapter.PlaylistAdapter;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Interface.RecyclerviewArtistItemOnClick;
import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;
import com.example.doan_10.Model.song.Song;
import com.example.doan_10.R;
import com.example.doan_10.View.AddSongPlaylistActivity;
import com.example.doan_10.View.HomeActivity;
import com.example.doan_10.View.ListenActivity;
import com.example.doan_10.View.LoginActivity;
import com.example.doan_10.View.MyPlaylistActivity;
import com.example.doan_10.View.SongArtistActivity;
import com.example.doan_10.View.TopArtistActivity;
import com.example.doan_10.View.TopSongActivity;
import com.example.doan_10.viewmodels.ListArtistViewModel;
import com.example.doan_10.viewmodels.ListSongViewModel;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Home extends Fragment implements RecyclerviewSongItemOnClick, RecyclerviewArtistItemOnClick {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  View view;
    private RecyclerView top_song, top_artist;
    private SongAdapter songAdapter;
    private ArtistAdapter artistAdapter;
    private ImageSlider slider;
    private ListArtistViewModel listArtistViewModel;
    private ListSongViewModel listSongViewModel;
    private ProgressBar progressBar1,progressBar2;
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
        view =inflater.inflate(R.layout.fragment__home, container, false);
        top_song = view.findViewById(R.id.song_top_id);
        top_artist = view.findViewById(R.id.artist_top_id);
        top_artist.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        top_song.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar1 = (ProgressBar) view.findViewById(R.id.progressBar1);
        progressBar2 = (ProgressBar) view.findViewById(R.id.progressBar2);
        Sprite wave = new Wave();
        progressBar1.setIndeterminateDrawable(wave);
        progressBar2.setIndeterminateDrawable(wave);
        listArtistViewModel = new ViewModelProvider(this).get(ListArtistViewModel.class);
        listArtistViewModel.getListArtist().observe(this.getViewLifecycleOwner(), list -> {
            artistAdapter = new ArtistAdapter(this.getContext(), list, this);
            progressBar1.setVisibility(View.GONE);
            top_artist.setAdapter(artistAdapter);
        });
        listSongViewModel = new ViewModelProvider(this).get(ListSongViewModel.class);
        listSongViewModel.getListSong().observe(this.getViewLifecycleOwner(), list -> {
            songAdapter = new SongAdapter(this.getContext(), list, this);
            progressBar2.setVisibility(View.GONE);
            top_song.setAdapter(songAdapter);
        });

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


    @Override
    public void onSongItemClick(int position) {
//        Song clickedSong = ListSong.get(position);
//        Intent intent = new Intent(getContext(), ListenActivity.class);
//        intent.putExtra("imageId", clickedSong.getImageId());
//        intent.putExtra("nameSong", clickedSong.getNameSong());
//        intent.putExtra("singer", clickedSong.getSinger());
//        intent.putExtra("file", clickedSong.getFile());
//        intent.putExtra("ListSong",ListSong);
//        intent.putExtra("IndexSong", position);
//        startActivity(intent);
    }

    @Override
    public void onArtistItemClick(int position) {
//        Artist clickedArtist = ListArtist.get(position);
//        Intent intent = new Intent(getContext(), SongArtistActivity.class);
//        intent.putExtra("imageId", clickedArtist.getImageId());
//        intent.putExtra("nameArtist", clickedArtist.getName());
//        startActivity(intent);
    }

}