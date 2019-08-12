package com.example.sqrrlandriodtask.model;

import com.google.gson.annotations.SerializedName;

public class DogsResponse {
    @SerializedName("status")
    boolean status;

    public boolean isStatus() {
        return this.status;
    }
}
