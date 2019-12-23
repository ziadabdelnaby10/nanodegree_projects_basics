package com.example.nanodegree_project4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity {

    ImageButton btnPlay , btnPause , btnStop;
    TextView name;
    MediaPlayer mediaPlayer;
    int pausePosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        name = findViewById(R.id.recName);
        name.setText(getIntent().getExtras().getString("songname"));
        btnPlay = findViewById(R.id.plaY);
        btnPause = findViewById(R.id.pause);
        btnStop = findViewById(R.id.stop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null)
                {
                    mediaPlayer = MediaPlayer.create(getApplicationContext() , R.raw.shortsong);
                    mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(pausePosition);
                    mediaPlayer.start();
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null)
                {
                    mediaPlayer.pause();
                    pausePosition = mediaPlayer.getCurrentPosition();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer!=null)
        {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuitems , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id)
        {
            case R.id.library:
                Intent i = new Intent(this , MainActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.listen:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
