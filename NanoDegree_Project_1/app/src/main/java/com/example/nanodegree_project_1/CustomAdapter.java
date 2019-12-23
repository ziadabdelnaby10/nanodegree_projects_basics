package com.example.nanodegree_project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class CustomAdapter extends PagerAdapter {
    ArrayList<model> data = new ArrayList<>();
    Context c;
    LayoutInflater layoutInflater;
    public CustomAdapter(ArrayList<model> data, Context c) {
        this.data = data;
        this.c = c;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = LayoutInflater.from(c);
        View v = layoutInflater.inflate(R.layout.pageviewer_layout , container , false);
        ImageView img = v.findViewById(R.id.img_pageViewer);
        img.setImageResource(data.get(position).getImg());
        container.addView(v , 0);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
