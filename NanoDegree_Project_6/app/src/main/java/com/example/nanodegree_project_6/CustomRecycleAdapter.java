package com.example.nanodegree_project_6;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.myViewHolder> {

    private Context c;
    private ArrayList<ParsedJson> list;


    public CustomRecycleAdapter(Context c, ArrayList<ParsedJson> list) {
        this.c = c;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomRecycleAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout, parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecycleAdapter.myViewHolder holder, int position) {
        holder.Name.setText(list.get(position).getName());
        holder.Date.setText(list.get(position).getDate());
        holder.Title.setText(list.get(position).getTile());
        holder.Author.setText(list.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView Name, Date, Title, Author;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            Date = itemView.findViewById(R.id.date);
            Title = itemView.findViewById(R.id.title);
            Author = itemView.findViewById(R.id.author);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(getAdapterPosition()).getWebUrl().trim()));
                    c.startActivity(i);
                }
            });
        }

    }
}
