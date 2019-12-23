package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nanodegree_project4.MusicActivity;
import com.example.nanodegree_project4.R;

import java.util.ArrayList;

import Model.SongsModel;

public class RecylerviewCustomAdapter extends RecyclerView.Adapter<RecylerviewCustomAdapter.myviewHolder> {

    ArrayList<SongsModel> list_songs;
    Context context;

    public RecylerviewCustomAdapter(ArrayList<SongsModel> list_songs, Context context) {
        this.list_songs = list_songs;
        this.context = context;
    }

    @NonNull
    @Override
    public RecylerviewCustomAdapter.myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewlayout , parent , false);

        return new myviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerviewCustomAdapter.myviewHolder holder, int position) {
        holder.name.setText(list_songs.get(position).getName());
        holder.artist.setText(list_songs.get(position).getArtist_name());
        holder.date.setText(list_songs.get(position).getDate().toString());
    }

    @Override
    public int getItemCount() {
        return list_songs.size();
    }

    public class myviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name , artist , date;
        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.songName);
            artist = itemView.findViewById(R.id.artistName);
            date = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context , MusicActivity.class);
            intent.putExtra("songname" , list_songs.get(position).getName());
            context.startActivity(intent);
        }
    }
}
