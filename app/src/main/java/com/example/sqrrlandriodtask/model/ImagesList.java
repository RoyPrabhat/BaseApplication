package com.example.sqrrlandriodtask.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ImagesList extends DogsResponse {
    @SerializedName("message")
    ArrayList<String> imageList;

    public ArrayList<String> getImageList() {
        return new ArrayList<>(this.imageList);
    }
}
