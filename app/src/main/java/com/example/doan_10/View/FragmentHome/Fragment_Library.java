package com.example.doan_10.View.FragmentHome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.doan_10.R;
import com.example.doan_10.View.AllSongsActivity;
import com.example.doan_10.View.LoginActivity;
import com.example.doan_10.View.MyHistoryActivity;
import com.example.doan_10.View.MyPlaylistActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Library#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Library extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;

    public Fragment_Library() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Library.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Library newInstance(String param1, String param2) {
        Fragment_Library fragment = new Fragment_Library();
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
        view = inflater.inflate(R.layout.fragment__library, container, false);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("IdUser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int userID = sharedPreferences.getInt("id_user",0);
        LinearLayout[] linearLayouts = new LinearLayout[3];
        int[] linearLayoutIds = {R.id.allSongs, R.id.allPlaylists, R.id.allHistory};
        for (int i = 0; i < linearLayouts.length; i++) {
            linearLayouts[i] = view.findViewById(linearLayoutIds[i]);
            final int index = i;
            linearLayouts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (index) {
                        case 0:
                            if(userID != 0) {
                                Intent intent11 = new Intent(getActivity(), AllSongsActivity.class);
                                startActivity(intent11);
                            }
                            else {
                                Toast.makeText(getContext(), "Please login to access!", Toast.LENGTH_SHORT).show();
                                Intent intent12 = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent12);
                            }
                            break;
                        case 1:
                            if(userID != 0) {
                                Intent intent21 = new Intent(getActivity(), MyPlaylistActivity.class);
                                startActivity(intent21);
                            }
                            else {
                                Toast.makeText(getContext(), "Please login to access!", Toast.LENGTH_SHORT).show();
                                Intent intent22 = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent22);
                            }
                            break;
                        case 2:
                            if(userID != 0) {
                                Intent intent31 = new Intent(getActivity(), MyHistoryActivity.class);
                                startActivity(intent31);
                            }
                            else {
                                Toast.makeText(getContext(), "Please login to access!", Toast.LENGTH_SHORT).show();
                                Intent intent32 = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent32);
                            }
                            break;
                    }
                }
            });
        }
        return view;
    }
}