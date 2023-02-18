package com.eng.ashm.topmovies.data.datasource;

import android.database.Observable;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.eng.ashm.topmovies.data.DataSourceListener;
import com.eng.ashm.topmovies.data.backend.BackendResponseModel;
import com.eng.ashm.topmovies.data.backend.MovieApi;
import com.eng.ashm.topmovies.data.backend.MovieDataModel;
import com.eng.ashm.topmovies.ui.MoviesViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * this class is the data source class that responsible for loading data from api
 */
public class MoviesApiDataSource {

    //test
   public  static final String TAG = "debug-test";

   public DataSourceListener<List<MovieDataModel>> listener = null;
   private final static  String baseUrl = "https://imdb-api.com/API/Top250Movies/";
   private static final String apiKey = "k_l1p2rebe";
   private static  Retrofit retrofit = null;

    public MoviesApiDataSource(DataSourceListener<List<MovieDataModel>> listener){
       this.listener = listener;
    }

    /**
     * this method create an instance from retrofit and follow the singleTon design pattern.
     * the reason why this method follow this design pattern is that for each request we will
     * create a new retrofit object and this is not efficient
     */
   private synchronized static void createRetrofitInstance(){
       if(retrofit == null){
           try{
               retrofit =new  Retrofit.Builder()
                       .baseUrl(baseUrl)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();
           }
           catch (Exception ex){
               Log.d(TAG, "createRetrofitInstance: Error Exception" + ex.getMessage() );
           }

       }
   }
    /**
     * this method  load all the movies available in the api
     * @return list of movies to be available for the app
     */
   public void getAllMovies(){
         createRetrofitInstance();
         MovieApi api =  retrofit.create(MovieApi.class);
         api.getMovies(apiKey).enqueue(
                 new Callback<BackendResponseModel>() {
                     @Override
                     public void onResponse(Call<BackendResponseModel> call, Response<BackendResponseModel> response) {

                            if(response.code() == 200){
//                         Log.d(TAG,response.body().getItems().get(1).getTitle());
                              if(listener != null)
                              listener.update(response.body().getItems());
                            }
                     }

                     @Override
                     public void onFailure(Call<BackendResponseModel>call, Throwable t) {
                         Log.d(TAG, "error occurred in the request : "+ t.toString());
                         call.cancel();
                     }
                 }
         );
   }
}
