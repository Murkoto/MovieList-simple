package com.example.win10.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by WIN10 on 11/03/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, director, genre, year;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            director = (TextView) view.findViewById(R.id.director);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }

    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(filter(movie.getTitle()));
        holder.director.setText(filter(movie.getDirector()));
        holder.genre.setText(filter(movie.getGenre()));
        holder.year.setText(filter(movie.getYear()));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public String filter(String str) {
        String ret = str;
        if (ret.length() >25) {
            ret = ret.substring(0, 24) + "...";
        }
        return ret;
    }

}
