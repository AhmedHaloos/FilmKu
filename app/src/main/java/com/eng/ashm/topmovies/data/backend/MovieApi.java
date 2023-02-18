package com.eng.ashm.topmovies.data.backend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieApi {

    @GET("{apiKey}")
    Call<BackendResponseModel> getMovies(@Path("apiKey") String apiKey);
}
