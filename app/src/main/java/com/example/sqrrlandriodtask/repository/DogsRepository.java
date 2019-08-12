package com.example.sqrrlandriodtask.repository;

import android.media.Image;

import androidx.lifecycle.MutableLiveData;

import com.example.sqrrlandriodtask.api.DogsApiClient;
import com.example.sqrrlandriodtask.api.DogsApiService;
import com.example.sqrrlandriodtask.model.BreedsList;
import com.example.sqrrlandriodtask.model.ImagesList;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogsRepository {

    private static DogsRepository mDogsRepository;
    private DogsApiService mDogsAPIService;

    public static DogsRepository getInstance() {
        if (mDogsRepository == null) {
            mDogsRepository = new DogsRepository();
        }
        return mDogsRepository;
    }


    public DogsRepository() {
        mDogsAPIService = DogsApiClient.getInstance().getDogsAPIService();
    }

    public MutableLiveData<ArrayList<String>> getBreedList() {
        final MutableLiveData<ArrayList<String>> mBreedList = new MutableLiveData<>();
        mDogsAPIService.getBreedList().enqueue(new Callback<BreedsList>() {
            @Override
            public void onResponse(Call<BreedsList> call, Response<BreedsList> response) {
                if (response.isSuccessful()) {
                    mBreedList.setValue(response.body().getBreedList());
                }
            }

            @Override
            public void onFailure(Call<BreedsList> call, Throwable t) {
                mBreedList.setValue(null);
            }
        });

        return mBreedList;

    }

    public MutableLiveData<ImagesList> getImageList(String imageNAme) {
        final MutableLiveData<ImagesList> imageList = new MutableLiveData<>();
        mDogsAPIService.getImageList(imageNAme).enqueue(new Callback<ImagesList>() {
            @Override
            public void onResponse(Call<ImagesList> call,
                                   Response<ImagesList> response) {
                if (response.isSuccessful()) {
                    imageList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ImagesList> call, Throwable t) {
                imageList.setValue(null);
            }
        });
        return imageList;

    }
}
