package com.example.nanodegree_project_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class scoreActivity extends AppCompatActivity {

    private int recived_score;
    private String recived_name;
    TextView txtName;
    Button btn_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        btn_score = findViewById(R.id.Final_score);
        txtName = findViewById(R.id.Namee);
        recived_name = getIntent().getExtras().getString("Name");
        recived_score = getIntent().getExtras().getInt("Score");
        txtName.setText("Congrats " + recived_name);
        btn_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , "Your Final Score is " + recived_score + " / 4" , Toast.LENGTH_LONG).show();
            }
        });

    }
}
