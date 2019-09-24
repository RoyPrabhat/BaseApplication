package com.example.sqrrlandriodtask.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sqrrlandriodtask.repository.DogsRepository;

import java.util.ArrayList;

public class BreedListViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> mBreedList;
    private DogsRepository mDogsRepository;

    public BreedListViewModel(DogsRepository repository) {
        this.mDogsRepository = repository;
    }

    public void fetchBreedList() {
        if (mBreedList != null) {
            return;
        }
        mDogsRepository = DogsRepository.getInstance();
        this.mBreedList = mDogsRepository.getBreedList();
    }

    public MutableLiveData<ArrayList<String>> getBreedList() {
        if (this.mBreedList == null) {
            this.mBreedList = new MutableLiveData<>();
            fetchBreedList();
        }
        return this.mBreedList;
    }
}
