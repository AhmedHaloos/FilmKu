package com.eng.ashm.topmovies.ui.adapter;

import static com.eng.ashm.topmovies.data.datasource.MoviesApiDataSource.TAG;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eng.ashm.topmovies.R;
import com.eng.ashm.topmovies.data.backend.MovieDataModel;
import com.eng.ashm.topmovies.databinding.MovieItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * movies adapter for RecyclerView for displaying movies
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {


    private List<MovieDataModel> movies ;

    public MovieAdapter(List<MovieDataModel> movies){this.movies = movies;}

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieItemView = MovieItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false).getRoot();
        return new MovieViewHolder(movieItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.movieItemBinding.filmTitle.setText(movies.get(position).getTitle()+"");
        holder.movieItemBinding.filmYear.setText(movies.get(position).getYear()+"");
        holder.movieItemBinding.rate.setText(movies.get(position).getImdbRating()+"/10 IMDb");
        Picasso.get().load(movies.get(position).getImgSource())
                .fit()
                .placeholder(R.drawable.notfoundimage)
                .into(holder.movieItemBinding.filmImg);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    /**
     * this method update the RecyclerView adapter with the movies list provided
     * to it as arguments.
     * @param movies to update the adapter list
     */
    public void updateMovieList(List<MovieDataModel> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    /**
     * accessor to the movies list
     * @return the movies list in the adapter
     */
    public List<MovieDataModel> getMovieList(){
        return movies;
    }


}

class MovieViewHolder extends RecyclerView.ViewHolder{

    MovieItemBinding movieItemBinding;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
       movieItemBinding =  MovieItemBinding.bind(itemView);
    }
}
