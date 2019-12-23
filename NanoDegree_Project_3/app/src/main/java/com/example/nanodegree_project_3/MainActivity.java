package com.example.nanodegree_project_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextName);
    }
    public void begin(View view) {
        Intent i = new Intent(this , question1.class);
        Bundle b = new Bundle();
        b.putString("Name",name.getText().toString().trim());
        i.putExtras(b);
        startActivity(i);
        finish();
    }
}
