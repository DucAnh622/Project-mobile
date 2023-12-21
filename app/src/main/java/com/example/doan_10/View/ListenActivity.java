package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.doan_10.Model.song.Song;
import com.example.doan_10.R;
import com.example.doan_10.viewmodels.SongViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListenActivity extends AppCompatActivity {
    private Button back_listen, close_listen, random, prev, play, next, replay;
    private ImageView ImageSongId;
    private TextView SongName, SingerName, currentTime, totalTime;
    private String nameSong;
    private String singer;
    private SeekBar seekBar;
    private int imageId, File;
    private String imageUrl;
    private boolean isTracking = false;
    private MediaPlayer mediaPlayer;
    private List<Song> ListCurrentSong;
    private int IndexSong;
    private int id_song;
    private SongViewModel songViewModel;
    public ListenActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        back_listen = findViewById(R.id.back_listen);
        close_listen = findViewById(R.id.Close_listen);
        random = findViewById(R.id.random_id);
        prev = findViewById(R.id.prev_id);
        play = findViewById(R.id.play_id);
        next = findViewById(R.id.next_id);
        replay = findViewById(R.id.replay_id);

        seekBar = findViewById(R.id.seekBar_id);

        // Xoay ảnh
        ImageSongId = findViewById(R.id.ImageId);
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(ImageSongId, "rotation", 0f, 360f);
        rotationAnimator.setInterpolator(new LinearInterpolator());
        rotationAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rotationAnimator.setDuration(10000);
                rotationAnimator.start();
            }
        }, 1000);

        SongName = findViewById(R.id.Song_name);
        SongName.setSelected(true);
        SingerName = findViewById(R.id.Singer_name);
        SingerName.setSelected(true);
        currentTime = findViewById(R.id.current_time_id);
        totalTime = findViewById(R.id.total_time_id);

        Intent intent = getIntent();
        if (intent != null) {
            imageUrl = intent.getStringExtra("imageUrl");
            nameSong = intent.getStringExtra("nameSong");
            singer = intent.getStringExtra("singer");
            Picasso.get().load(imageUrl).into(ImageSongId);
            SongName.setText(nameSong);
            SingerName.setText(singer);
            String musicUrl = intent.getStringExtra("musicUrl");
            ListCurrentSong = (List<Song>) getIntent().getSerializableExtra("ListSong");
            IndexSong = intent.getIntExtra("IndexSong",0);
            mediaPlayer = MediaPlayer.create(this, Uri.parse(musicUrl));
            mediaPlayer.start();
            play.setBackgroundResource(R.drawable.baseline_pause_circle_24);
            seekBar.setMax(mediaPlayer.getDuration());
        }

        // Seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isTracking = true;
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isTracking = false;

                if (mediaPlayer != null) {
                    int progress = seekBar.getProgress();
                    mediaPlayer.seekTo(progress);
                }
            }
        });

        updateSeekBar();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    rotationAnimator.pause();
                    play.setBackgroundResource(R.drawable.baseline_play_circle_24);
                } else {
                    mediaPlayer.start();
                    rotationAnimator.resume();
                    play.setBackgroundResource(R.drawable.baseline_pause_circle_24);
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ListCurrentSong != null && !ListCurrentSong.isEmpty()) {
                    if (IndexSong > 0) {
                        IndexSong--;
                        playNewSong();
                    } else {
                        IndexSong = ListCurrentSong.size() - 1;
                    }
                    playNewSong();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ListCurrentSong != null && !ListCurrentSong.isEmpty()) {
                    if (IndexSong < ListCurrentSong.size() - 1) {
                        IndexSong++;
                        playNewSong();
                    }else {
                        IndexSong = 0;
                    }
                    playNewSong();
                }
            }
        });

        back_listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                play.setBackgroundResource(R.drawable.baseline_play_circle_24);
                onBackPressed();
            }
        });

        close_listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                Intent intent = new Intent(ListenActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("nameSong", nameSong);
        intent.putExtra("singer", singer);
        intent.putExtra("imageId",imageId);
        intent.putExtra("file",File);
        startActivity(intent);
        finish();
    }

    private void updateSeekBar() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && !isTracking) {
                    try {
                        int currentPosition = mediaPlayer.getCurrentPosition();
                        seekBar.setProgress(currentPosition);
                        currentTime.setText(formatTime(currentPosition));
                        totalTime.setText(formatTime(mediaPlayer.getDuration()));
                    }
                    catch(IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
                handler.postDelayed(this, 1000);
            }
        }, 1000);
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            handler.removeCallbacksAndMessages(null);
        }
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void playNewSong() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Song newSong = ListCurrentSong.get(IndexSong);
        imageUrl = newSong.getAvatar();
        nameSong = newSong.getTitle();
        singer = newSong.getNameArtist();
//        File = newSong.getFile();
        String musicUrl = newSong.getUrlMusic();

        Picasso.get().load(imageUrl).into(ImageSongId);
        SongName.setText(nameSong);
        SingerName.setText(singer);

        mediaPlayer = MediaPlayer.create(ListenActivity.this, Uri.parse(musicUrl));
        mediaPlayer.start();
        play.setBackgroundResource(R.drawable.baseline_pause_circle_24);
        seekBar.setMax(mediaPlayer.getDuration());

        // Cập nhật lại thanh seekBar và thời gian
        updateSeekBar();
    }

    private String formatTime(int millis) {
        int seconds = millis / 1000;
        int minutes = seconds / 60;

        seconds = seconds % 60;
        minutes = minutes % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}