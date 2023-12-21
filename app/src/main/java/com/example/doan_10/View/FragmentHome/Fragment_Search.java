package com.example.doan_10.View.FragmentHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_10.Adapter.ArtistAdapter;
import com.example.doan_10.Adapter.SongAdapter;
import com.example.doan_10.Interface.RecyclerviewArtistItemOnClick;
import com.example.doan_10.Interface.RecyclerviewSongItemOnClick;
import com.example.doan_10.Model.song.Song;
import com.example.doan_10.R;
import com.example.doan_10.View.ListenActivity;
import com.example.doan_10.viewmodels.ListArtistViewModel;
import com.example.doan_10.viewmodels.ListSongViewModel;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Search extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText searchButton;
    private RecyclerView listSearchArtist, listSearchSong;
    private ListSongViewModel listSongViewModel;
    private ListArtistViewModel listArtistViewModel;
    private ArtistAdapter artistAdapter;
    private SongAdapter songAdapter;
    private ProgressBar progressBar1, progressBar2;

    public Fragment_Search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Search.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Search newInstance(String param1, String param2) {
        Fragment_Search fragment = new Fragment_Search();
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
        View view = inflater.inflate(R.layout.fragment__search, container, false);
        EditText searchButton = view.findViewById(R.id.SearchView);
        listSearchArtist = view.findViewById(R.id.list_rs_artist);
        listSearchSong = view.findViewById(R.id.list_rs_song);
        listSearchArtist.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        listSearchSong.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar1 = (ProgressBar) view.findViewById(R.id.progressBar1);
        progressBar2 = (ProgressBar) view.findViewById(R.id.progressBar2);
        Sprite wave = new Wave();
        progressBar1.setIndeterminateDrawable(wave);
        progressBar2.setIndeterminateDrawable(wave);
        progressBar1.setVisibility(View.GONE);
        progressBar2.setVisibility(View.GONE);
        searchButton.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_SEARCH
                || i == EditorInfo.IME_ACTION_DONE
                || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                || keyEvent.getAction() == keyEvent.KEYCODE_ENTER) {
                    String keyword = searchButton.getText().toString();
                    if(keyword.isEmpty()) {
                        Toast.makeText(getActivity(), "Error invalid keyword", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getActivity(), "get "+keyword+" successfully!" , Toast.LENGTH_SHORT).show();
                        getSearchResult(keyword);
                    }
                    searchButton.setText("");
                }
                return false;
            }
        });
        return  view;
    }

    private void getSearchResult(String key) {
        listArtistViewModel = new ViewModelProvider(this).get(ListArtistViewModel.class);
        listArtistViewModel.getListArtistSearch(key).observe(this.getViewLifecycleOwner(), list ->{
            artistAdapter = new ArtistAdapter(this.getContext(), list, new RecyclerviewArtistItemOnClick() {
                @Override
                public void onArtistItemClick(int position) {

                }
            });
            listSearchArtist.setAdapter(artistAdapter);
            progressBar1.setVisibility(View.GONE);
        });

        listSongViewModel = new ViewModelProvider(this).get(ListSongViewModel.class);
        listSongViewModel.getListSongSearch(key).observe(this.getViewLifecycleOwner(), list -> {
            songAdapter = new SongAdapter(this.getContext(), list, new RecyclerviewSongItemOnClick() {
                @Override
                public void onSongItemClick(int position) {
                    Song song = list.get(position);
                    List<Song> ListSong = list;
                    Intent intent = new Intent(getContext(), ListenActivity.class);
                    intent.putExtra("imageUrl", song.getAvatar());
                    intent.putExtra("nameSong", song.getTitle());
                    intent.putExtra("singer", song.getNameArtist());
                    intent.putExtra("musicUrl", song.getUrlMusic());
//                    ArrayList<Song> arrSong = list.stream().collect(Collectors.toCollection(ArrayList::new));
                    intent.putExtra("ListSong", (Serializable) list);
                    intent.putExtra("IndexSong", position);
                    startActivity(intent);
                }
            });
            listSearchSong.setAdapter(songAdapter);
            progressBar2.setVisibility(View.GONE);
        });
    }


}