package com.example.sqrrlandriodtask.api;

import com.example.sqrrlandriodtask.model.BreedsList;
import com.example.sqrrlandriodtask.model.ImagesList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogsApiService {

    @GET("breeds/list/all")
    Call<BreedsList> getBreedList();

    @GET("breed/{breedName}/images")
    Call<ImagesList> getImageList(@Path("breedName") String str);

}
