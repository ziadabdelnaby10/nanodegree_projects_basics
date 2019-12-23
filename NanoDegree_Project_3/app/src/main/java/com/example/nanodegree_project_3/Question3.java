package com.example.nanodegree_project_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    private String name;
    private int score;
    CheckBox checkBox1 , checkBox2 , checkbox3 , checkbox4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        score = getIntent().getExtras().getInt("Score");
        name = getIntent().getExtras().getString("Name");
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkbox3 = findViewById(R.id.checkBox3);
        checkbox4 = findViewById(R.id.checkBox4);

    }

    public int cheeck()
    {
        if(checkBox2.isChecked() && checkbox3.isChecked() && checkbox4.isChecked())
        {
            return 1;
        }
        else
            return 0;
    }
    public void next_3(View view) {
        score += cheeck();
        if(checkBox2.isChecked() && checkbox3.isChecked() && checkbox4.isChecked())
            Toast.makeText(this , "Right" , Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this , "Wrong" , Toast.LENGTH_LONG).show();
        Intent i = new Intent(this , Question4.class);
        Bundle b = new Bundle();
        b.putString("Name",name);
        b.putInt("Score" , score);
        i.putExtras(b);
        startActivity(i);
        finish();
    }
}