package com.example.sqrrlandriodtask.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sqrrlandriodtask.model.ImagesList;
import com.example.sqrrlandriodtask.repository.DogsRepository;

public class ImageListViewModel extends AndroidViewModel {

    private MutableLiveData<ImagesList> mImageList;
    private String mDogName;
    private DogsRepository mDogsRepository;
    public ImageListViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchImageList() {
        if (mImageList != null) {
            return;
        }
        mDogsRepository = DogsRepository.getInstance();
        this.mImageList = mDogsRepository.getImageList(this.mDogName);
    }

    public MutableLiveData<ImagesList> getImageList() {
        if (this.mImageList == null) {
            this.mImageList = new MutableLiveData<>();
            fetchImageList();
        }
        return this.mImageList;
    }

    public void setDogName(String dogName) {
        if (this.mDogName == null) {
            this.mDogName = dogName;
        }
    }
}
