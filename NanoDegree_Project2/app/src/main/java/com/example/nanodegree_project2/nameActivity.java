package com.example.nanodegree_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class nameActivity extends AppCompatActivity {

    Button btn_done;
    EditText firsttxt , secondtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        firsttxt = findViewById(R.id.first);
        secondtxt = findViewById(R.id.second);
        btn_done = findViewById(R.id.btn_done);
    }

    public void btnDone(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        Bundle b = new Bundle();
        b.putString("First" , firsttxt.getText()+"");
        b.putString("Second" , secondtxt.getText()+"");
        intent.putExtras(b);
        startActivity(intent);
        this.finish();
    }
}
