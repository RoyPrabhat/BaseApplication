package com.example.sqrrlandriodtask.di;

import com.example.sqrrlandriodtask.api.DogsApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    public static final String BASE_API_URL = "https://dog.ceo/api/";

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    DogsApiService providesDogsApiService(Retrofit retrofit) {
        return retrofit.create(DogsApiService.class);
    }
}
