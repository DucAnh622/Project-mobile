package com.example.doan_10.View.FragmentHome;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.doan_10.R;
import com.example.doan_10.View.LoginActivity;
import com.example.doan_10.View.MyPlaylistActivity;
import com.example.doan_10.View.SongArtistActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Menu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private LinearLayout manage_account, Account_Logout, Account_Login;
    private Button loginBTN, logoutBTN;

    public Fragment_Menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Menu newInstance(String param1, String param2) {
        Fragment_Menu fragment = new Fragment_Menu();
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
        view = inflater.inflate(R.layout.fragment__menu, container, false);
        loginBTN = view.findViewById(R.id.toLogin);
        Account_Logout = view.findViewById(R.id.Account_Logout);
        Account_Login = view.findViewById(R.id.Account_Login);
        manage_account = view.findViewById(R.id.Manage_Account);
        logoutBTN = view.findViewById(R.id.toLogout);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("IdUser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int userID = sharedPreferences.getInt("id_user",0);
        if (userID != 0) {
            manage_account.setVisibility(View.VISIBLE);
            Account_Login.setVisibility(View.GONE);
            Account_Logout.setVisibility(View.VISIBLE);
        }

        logoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.putInt("id_user",0);
                editor.apply();
                manage_account.setVisibility(View.GONE);
                Account_Login.setVisibility(View.VISIBLE);
                Account_Logout.setVisibility(View.GONE);
            }
        });

        RelativeLayout[] relativeLayouts = new RelativeLayout[4];
        int[] relativeLayoutIds = {R.id.setting, R.id.infor, R.id.support, R.id.contact};
        for (int i = 0; i < relativeLayouts.length; i++) {
            relativeLayouts[i] = view.findViewById(relativeLayoutIds[i]);
            final int index = i;
            relativeLayouts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (index) {
                        case 0:
                            Toast.makeText(getActivity(), "Coming soon!", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(getActivity(), "Coming soon!", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(getActivity(), "Coming soon!", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(getActivity(), "Coming soon!", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        }

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.doan_10.View.LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}