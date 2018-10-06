package com.gagandeep.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView button;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.touching_the_stars);
        button = findViewById(R.id.buttonMedia);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPauseButton();
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                resetSong();
                return true;
            }
        });
    }
    private void resetSong() {
        if (mediaPlayer.isPlaying())
            mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show();
    }

    private void playPauseButton() {


        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            button.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_circle));
//            button.setText("Play");
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        }
        else {
            mediaPlayer.start();
            button.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_circle));
//            button.setText("Pause");
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }





    @Override
    protected void onPause(){
        super.onPause();
        mediaPlayer.pause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
}
