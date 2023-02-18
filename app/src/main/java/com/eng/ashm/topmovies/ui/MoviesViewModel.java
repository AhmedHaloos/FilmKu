package com.eng.ashm.topmovies.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eng.ashm.topmovies.data.MoviesRepository;
import com.eng.ashm.topmovies.data.backend.MovieDataModel;

import java.util.List;

public class MoviesViewModel extends ViewModel {

    MoviesRepository moviesRepository = MoviesRepository.getInstance();

    public MutableLiveData<List<MovieDataModel>> getMovies(){
        moviesRepository.getMovies();
        return moviesRepository.moviesList;
    }

}
