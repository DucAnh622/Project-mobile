package com.example.doan_10.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.doan_10.R;
import com.example.doan_10.View.FragmentHome.AdapterViewFragment;
import com.example.doan_10.View.FragmentHome.Fragemnt_Bottom_Listen;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class HomeActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    BottomNavigationView bottomNavigationView;
    AdapterViewFragment adapterViewFragment;

    Fragemnt_Bottom_Listen fragemntBottomListen;
    private String SongName,Singer;
    private int ImageId, File;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager2 = findViewById(R.id.fragment_wrap);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        adapterViewFragment = new AdapterViewFragment(this);
        viewPager2.setAdapter(adapterViewFragment);
        viewPager2.setUserInputEnabled(false);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.HOME) {
                    viewPager2.setCurrentItem(0);
                }
                else if (id == R.id.SEARCH) {
                    viewPager2.setCurrentItem(1);
                }
                else if (id == R.id.LIBRARY) {
                    viewPager2.setCurrentItem(2);
                }
                else if (id == R.id.MENU) {
                    viewPager2.setCurrentItem(3);
                }
                return true;
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.HOME).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.SEARCH).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.LIBRARY).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.MENU).setChecked(true);
                        break;
                }
                super.onPageSelected(position);
            }
        });
        if (getIntent().hasExtra("nameSong") && getIntent().hasExtra("singer")&& getIntent().hasExtra("imageId")) {
            showYourFragment();
        }
    }
    private void showYourFragment() {
        fragemntBottomListen = new Fragemnt_Bottom_Listen();

        SongName = getIntent().getStringExtra("nameSong");
        Singer = getIntent().getStringExtra("singer");
        ImageId = getIntent().getIntExtra("imageId", 0);
        File = getIntent().getIntExtra("file", -1);
        Bundle bundle = new Bundle();
        bundle.putString("nameSong", SongName);
        bundle.putString("singer", Singer);
        bundle.putInt("imageId", ImageId);
        bundle.putInt("file", File);
        fragemntBottomListen.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragemntBottomListen)
                .addToBackStack(null)
                .commit();
    }
}