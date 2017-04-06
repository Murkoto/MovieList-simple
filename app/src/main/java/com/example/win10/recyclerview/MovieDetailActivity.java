package com.example.win10.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    Movie movie;
    TextView title;
    TextView director;
    TextView genre;
    TextView year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        title = (TextView) findViewById(R.id.movie_title_detail);
        director = (TextView) findViewById(R.id.movie_director_detail);
        genre = (TextView) findViewById(R.id.movie_genre_detail);
        year = (TextView) findViewById(R.id.movie_year_detail);

        Intent info = getIntent();

        String titleText = info.getStringExtra("title");
        String directorText = info.getStringExtra("director");
        String genreText = info.getStringExtra("genre");
        String yearText = info.getStringExtra("year");

        setTitle(titleText);

        title.setText(titleText);
        director.setText("Director: "+directorText);
        genre.setText("Genre: "+genreText);
        year.setText("Year: "+yearText);
    }

}
