package com.example.sqrrlandriodtask.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.sqrrlandriodtask.repository.DogsRepository;
import java.util.ArrayList;

public class BreedListViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<String>> mBreedList;
    private DogsRepository mDogsRepository;

    public BreedListViewModel(@NonNull Application application) {
        super(application);
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
