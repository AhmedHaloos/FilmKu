package com.eng.ashm.topmovies;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eng.ashm.topmovies.data.backend.MovieDataModel;
import com.eng.ashm.topmovies.databinding.MainScreenBinding;
import com.eng.ashm.topmovies.databinding.MovieItemBinding;
import com.eng.ashm.topmovies.ui.MoviesViewModel;
import com.eng.ashm.topmovies.ui.adapter.MovieAdapter;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainScreenBinding mainScreenBinding;
    MovieItemBinding movieItemBinding;
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    MoviesViewModel moviesViewModel;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainScreenBinding = MainScreenBinding.inflate(getLayoutInflater());
        movieItemBinding = MovieItemBinding.inflate(getLayoutInflater());
        setContentView(mainScreenBinding.getRoot());
        //recyclerview
        recyclerView = mainScreenBinding.filmList;
        linearLayoutManager = new LinearLayoutManager(this);
        movieAdapter = new MovieAdapter(new ArrayList<>());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        //moviesViewModel
        moviesViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        moviesViewModel.getMovies().observe(this, movieDataModels -> {
            movieAdapter.updateMovieList(movieDataModels);
        });
         // sort chips components
        mainScreenBinding.yearFilter.setOnClickListener(v -> {
            List<MovieDataModel> sortedMovies = sortMoviesByYear(movieAdapter.getMovieList());
            movieAdapter.updateMovieList(sortedMovies);
            linearLayoutManager.scrollToPositionWithOffset(0, 0);
            mainScreenBinding.yearFilter.setChecked(true);
            mainScreenBinding.rateFilter.setChecked(false);
        });
        mainScreenBinding.rateFilter.setOnClickListener(v -> {
                    List<MovieDataModel> sortedMovies = sortMoviesByRate(movieAdapter.getMovieList());
                    movieAdapter.updateMovieList(sortedMovies);
                    linearLayoutManager.scrollToPositionWithOffset(0, 0);
                    mainScreenBinding.yearFilter.setChecked(false);
                    mainScreenBinding.rateFilter.setChecked(true);
                }
        );
    }

    /**
     * this method sort the movies by year
     * @param movies
     * @return
     */
    List<MovieDataModel> sortMoviesByYear(List<MovieDataModel> movies) {

        movies.sort(Comparator.comparingInt(MovieDataModel::getYear));
        return movies;
    }

    /**
     * this method sort the movies by Rate
     * @param movies
     * @return
     */
    List<MovieDataModel> sortMoviesByRate(List<MovieDataModel> movies) {
        movies.sort((movie1, movie2) -> {
            int rate1 = (int) (Double.parseDouble(movie1.getImdbRating()) * 100);
            int rate2 = (int) (Double.parseDouble(movie2.getImdbRating()) * 100);
            return rate1 - rate2;
        });
        return movies;
    }



}

