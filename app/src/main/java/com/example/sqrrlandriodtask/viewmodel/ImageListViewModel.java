package com.example.sqrrlandriodtask.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sqrrlandriodtask.model.ImagesList;
import com.example.sqrrlandriodtask.repository.DogsRepository;

public class ImageListViewModel extends ViewModel {

    private MutableLiveData<ImagesList> mImageList;
    private String mDogName;
    private DogsRepository mDogsRepository;

    public ImageListViewModel(DogsRepository repository) {
        this.mDogsRepository = repository;
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
