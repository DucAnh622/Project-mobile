package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doan_10.R;

public class AddPlaylistActivity extends AppCompatActivity {
    private Button cancelBTN, submitBTN;
    private EditText playlistText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_playlist);
        cancelBTN = findViewById(R.id.CancelButton);
        submitBTN = findViewById(R.id.SubmitButton);
        playlistText = findViewById(R.id.playlist);
        cancelBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPlaylistActivity.this, MyPlaylistActivity.class);
                startActivity(intent);
                finish();
            }
        });

        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playlist = playlistText.getText().toString();
                if(playlist.isEmpty()) {
                    Toast.makeText(AddPlaylistActivity.this, "Invalid input!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AddPlaylistActivity.this, "Create "+ playlist +" successfully!", Toast.LENGTH_SHORT).show();
                }
                playlistText.setText("");
            }
        });
    }
}