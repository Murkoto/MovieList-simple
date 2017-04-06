package com.example.win10.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);




        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {

            Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);

            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                intent.putExtra("title", movie.getTitle());
                intent.putExtra("director", movie.getDirector());
                intent.putExtra("genre", movie.getGenre());
                intent.putExtra("year", movie.getYear());
                startActivity(intent);
                // /Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();

    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "George Miller","Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Pete Docter","Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "J. J. Abrams","Action", "2015");
        movieList.add(movie);

        movie = new Movie("Departed, The", "Martin Scorsese","Drama", "2007");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

}
