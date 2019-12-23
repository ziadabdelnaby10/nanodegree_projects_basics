package com.example.nanodegree_project4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;

import Adapter.RecylerviewCustomAdapter;
import Model.SongsModel;

public class MainActivity extends AppCompatActivity {

    ArrayList<SongsModel> list = new ArrayList<SongsModel>();
    RecylerviewCustomAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        list.add(new SongsModel("What" , "Andrew" , new Date()));
        list.add(new SongsModel("No Way" , "Anwar" , new Date()));
        list.add(new SongsModel("Cut The ..." , "Sia" , new Date()));
        list.add(new SongsModel("Wait a minute" , "Adele" , new Date()));
        list.add(new SongsModel("not actuly a song" , "Ahmed" , new Date()));
        list.add(new SongsModel("i love me" , "Mesho" , new Date()));
        list.add(new SongsModel("The Joker" , "Loma" , new Date()));
        list.add(new SongsModel("What" , "Andrew" , new Date()));
        list.add(new SongsModel("No Way" , "Anwar" , new Date()));
        list.add(new SongsModel("Cut The ..." , "Sia" , new Date()));
        list.add(new SongsModel("Wait a minute" , "Adele" , new Date()));
        list.add(new SongsModel("not actuly a song" , "Ahmed" , new Date()));
        list.add(new SongsModel("i love me" , "Mesho" , new Date()));
        list.add(new SongsModel("The Joker" , "Loma" , new Date()));
        list.add(new SongsModel("What" , "Andrew" , new Date()));
        list.add(new SongsModel("No Way" , "Anwar" , new Date()));
        list.add(new SongsModel("Cut The ..." , "Sia" , new Date()));
        list.add(new SongsModel("Wait a minute" , "Adele" , new Date()));
        list.add(new SongsModel("not actuly a song" , "Ahmed" , new Date()));
        list.add(new SongsModel("i love me" , "Mesho" , new Date()));
        list.add(new SongsModel("The Joker" , "Loma" , new Date()));
        list.add(new SongsModel("What" , "Andrew" , new Date()));
        list.add(new SongsModel("No Way" , "Anwar" , new Date()));
        list.add(new SongsModel("Cut The ..." , "Sia" , new Date()));
        list.add(new SongsModel("Wait a minute" , "Adele" , new Date()));
        list.add(new SongsModel("not actuly a song" , "Ahmed" , new Date()));
        list.add(new SongsModel("i love me" , "Mesho" , new Date()));
        list.add(new SongsModel("The Joker" , "Loma" , new Date()));
        adapter = new RecylerviewCustomAdapter(list , this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(lm);
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
                break;
            case R.id.listen:
                Intent i = new Intent(this , MusicActivity.class);
                i.putExtra("songname" , "Now Playing");
                startActivity(i);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
