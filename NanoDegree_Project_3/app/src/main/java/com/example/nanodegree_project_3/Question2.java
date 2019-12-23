package com.example.nanodegree_project_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    private String name;
    private int score;
    EditText txtDiscover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        score = getIntent().getExtras().getInt("Score");
        name = getIntent().getExtras().getString("Name");
        txtDiscover = findViewById(R.id.discover);
    }

    public int cheeck()
    {
        if(txtDiscover.getText().toString().equalsIgnoreCase("newton"))
        {
            return 1;
        }
        else
            return 0;
    }

    public void next_2(View view) {
        score += cheeck();
        if(txtDiscover.getText().toString().equalsIgnoreCase("newton"))
            Toast.makeText(this , "Right" , Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this , "Wrong" , Toast.LENGTH_LONG).show();
        Intent i = new Intent(this , Question3.class);
        Bundle b = new Bundle();
        b.putString("Name",name);
        b.putInt("Score" , score);
        i.putExtras(b);
        startActivity(i);
        finish();
    }
}
