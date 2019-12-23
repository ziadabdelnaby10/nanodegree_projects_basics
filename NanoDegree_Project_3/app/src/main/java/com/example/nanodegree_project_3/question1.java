package com.example.nanodegree_project_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class question1 extends AppCompatActivity {

    private String name;
    private int score=0;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        radioButton = findViewById(R.id.correctAns1);
        name = getIntent().getExtras().getString("Name");
    }

    public int cheeck()
    {
        if(radioButton.isChecked())
        {
            return 1;
        }
        else
            return 0;
    }


    public void next_1(View view) {
        score += cheeck();
        if(radioButton.isChecked())
            Toast.makeText(this , "Right" , Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this , "Wrong" , Toast.LENGTH_LONG).show();
        Intent i = new Intent(this , Question2.class);
        Bundle b = new Bundle();
        b.putString("Name",name);
        b.putInt("Score" , score);
        i.putExtras(b);
        startActivity(i);
        finish();
    }
}
