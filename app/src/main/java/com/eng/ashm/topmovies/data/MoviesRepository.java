package com.eng.ashm.topmovies.data;

import androidx.lifecycle.MutableLiveData;

import com.eng.ashm.topmovies.data.backend.MovieDataModel;
import com.eng.ashm.topmovies.data.datasource.MoviesApiDataSource;

import java.util.List;

/**
 * this class is responsible for exposing the data retrieved from MoviesApiDataSource class to
 * the rest of the app
 * this class is a singleTon class to be the only gate for movies data
 */
public class MoviesRepository {

    public MutableLiveData<List<MovieDataModel>> moviesList = new MutableLiveData<>();
    private MoviesApiDataSource moviesApiDataSource = new MoviesApiDataSource(
          // notify moviesList with the data
            movieDataModels -> {moviesList.postValue(movieDataModels);}
    );
    private static MoviesRepository instance = null;

    private MoviesRepository(){}

    /**
     * factory method for creating only one instance of this class
     * @return the MoviesRepository instance
     */
    public static MoviesRepository getInstance(){
        if (instance == null){
            instance = new MoviesRepository();
        }
        return instance;
    }

    /**
     * this method is intended to load all the movies in the data source and make them available
     * to the rest of the application.
     * @return list of all movies available in the api
     */
    public void getMovies(){moviesApiDataSource.getAllMovies();}



}
