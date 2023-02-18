package com.eng.ashm.topmovies.data.backend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BackendResponseModel {

    @SerializedName("items")
    private List<MovieDataModel> items;
    @SerializedName("errorMessage")
    private String errorMessage = "";

    public List<MovieDataModel> getItems() {
        return items;
    }

    public void setItems(List<MovieDataModel> items) {
        this.items = items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
