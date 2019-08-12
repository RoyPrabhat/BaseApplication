package com.example.sqrrlandriodtask.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BreedsList extends DogsResponse {

    @SerializedName("message")
    JsonObject breedList;

    public ArrayList<String> getBreedList() {
        return new ArrayList<>(this.breedList.keySet());
    }
}
