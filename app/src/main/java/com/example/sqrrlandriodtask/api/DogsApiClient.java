package com.example.sqrrlandriodtask.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsApiClient {

    public static final String BASE_API_URL = "https://dog.ceo/api/";
    private static DogsApiClient mAPIClient;

    private static DogsApiService mDogsAPIService;

    public static DogsApiClient getInstance() {
        if (mAPIClient == null) {
            mAPIClient = new DogsApiClient();
        }
        return mAPIClient;
    }

    private DogsApiClient() {
        buildRetrofit();
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mDogsAPIService = retrofit.create(DogsApiService.class);
    }

    public DogsApiService getDogsAPIService() {
        return mDogsAPIService;
    }

}
