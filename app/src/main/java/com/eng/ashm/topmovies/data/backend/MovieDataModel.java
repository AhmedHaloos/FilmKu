package com.eng.ashm.topmovies.data.backend;

import com.google.gson.annotations.SerializedName;

import retrofit2.Retrofit;

public class MovieDataModel {
    @SerializedName("id")
    private String id;
    @SerializedName("rank")
    private int rank;
    @SerializedName("title")
    private String title;
    @SerializedName("fullTitle")
    private  String fullTitle;
    @SerializedName("year")
    private int year;
    @SerializedName("image")
    private String imgSource;
    @SerializedName("crew")
    private String crew;
    @SerializedName("imDbRating")
    private String imdbRating;
    @SerializedName("imDbRatingCount")
    private String imdbRatingCount;



    public String getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbRatingCount() {
        return imdbRatingCount;
    }

    public void setImdbRatingCount(String imdbRatingCount) {
        this.imdbRatingCount = imdbRatingCount;
    }
}
