package com.example.doan_10.View.FragmentHome;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.doan_10.Model.Song;
import com.example.doan_10.R;
import com.example.doan_10.View.ListenActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragemnt_Bottom_Listen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragemnt_Bottom_Listen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView SongName, Singer;
    private  View view;
    private LinearLayout Zoom;
    private ImageView ImageSongId;
    private Button prev,play,next;
    private MediaPlayer mediaPlayer;
    public Fragemnt_Bottom_Listen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragemnt_Bottom_Listen.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragemnt_Bottom_Listen newInstance(String param1, String param2) {
        Fragemnt_Bottom_Listen fragment = new Fragemnt_Bottom_Listen();
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
        view = inflater.inflate(R.layout.fragment__bottom__listen, container, false);
        SongName = view.findViewById(R.id.Song_name);
        Singer = view.findViewById(R.id.Singer_name);
        SongName.setSelected(true);
        Singer.setSelected(true);
        Zoom = view.findViewById(R.id.Bottom_listen_id);
        ImageSongId = view.findViewById(R.id.ImageId);

        prev = view.findViewById(R.id.prev_id);
        play = view.findViewById(R.id.play_id);
        next = view.findViewById(R.id.next_id);
        Zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setBackgroundResource(R.drawable.baseline_play_circle_24);
                String nameSong = SongName.getText().toString();
                String singer = Singer.getText().toString();
                int imageId = getArguments().getInt("imageId", 0);
                int File = getArguments().getInt("file", -1);
                Intent intent = new Intent(getContext(), ListenActivity.class);
                intent.putExtra("nameSong", nameSong);
                intent.putExtra("singer", singer);
                intent.putExtra("imageId", imageId);
                intent.putExtra("file",File);
                startActivity(intent);
            }
        });

        if (getArguments() != null) {
            String nameSong = getArguments().getString("nameSong");
            String singer = getArguments().getString("singer");
            int imageId = getArguments().getInt("imageId", 0);
            int File = getArguments().getInt("file", -1);
            setData(nameSong, singer, imageId, File);
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer!=null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play.setBackgroundResource(R.drawable.baseline_play_circle_24);
                } else {
                    mediaPlayer.start();
                    play.setBackgroundResource(R.drawable.baseline_pause_circle_24);
                }
            }
        });

        return view;
    }
    public void setData(String nameSong, String singer, int imageId, int File) {
        SongName.setText(nameSong);
        Singer.setText(singer);
        ImageSongId.setImageResource(imageId);
    }
}