 package com.example.nanodegree_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Integer imges[] = {R.drawable.carpenter1 , R.drawable.carpenter2 , R.drawable.carpenter3};
    CustomAdapter adapter;
    ArrayList<model> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        data = new ArrayList<>();
        data.add(new model(R.drawable.carpenter1));
        data.add(new model(R.drawable.carpenter2));
        data.add(new model(R.drawable.carpenter3));
        adapter = new CustomAdapter(data , getApplicationContext());
        viewPager.setAdapter(adapter);
        viewPager.setPadding(100 , 0 , 100 , 0);
    }
}
