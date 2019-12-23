package com.example.nanodegree_project_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class spalshScreen extends AppCompatActivity {

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        image = findViewById(R.id.img);
        Handler hd = new Handler();
        YoYo.with(Techniques.FadeIn)
                .duration(2000)
                .repeat(0)
                .playOn(image);
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(i);
                finish();
            }
        } , 3000);
    }
}
