package com.example.nanodegree_project4;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class splashActivity extends AppCompatActivity {

    private ImageView img;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img = findViewById(R.id.imageView2);
        txt = findViewById(R.id.textView);
        Handler hd = new Handler();
        YoYo.with(Techniques.Wave)
                .duration(2000)
                .repeat(0)
                .playOn(img);
        YoYo.with(Techniques.Wave)
                .duration(2000)
                .repeat(0)
                .playOn(txt);
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(i);
                finish();
            }
        } , 2000);
    }
}
