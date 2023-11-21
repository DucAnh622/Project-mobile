package com.example.doan_10.View.FragmentHome;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterViewFragment extends FragmentStateAdapter {

    public AdapterViewFragment(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment_Home();
            case 1:
                return new Fragment_Search();
            case 2:
                return new Fragment_Library();
            case 3:
                return new Fragment_Menu();
            default:
                return new Fragment_Home();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
