package com.example.sqrrlandriodtask.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.sqrrlandriodtask.repository.DogsRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final DogsRepository mDogsRepository;

    public ViewModelFactory(DogsRepository repository) {
        mDogsRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BreedListViewModel.class)) {
            return (T) new BreedListViewModel(mDogsRepository);

        } else if (modelClass.isAssignableFrom(ImageListViewModel.class)) {
            return (T) new ImageListViewModel(mDogsRepository);
        } else {
            throw new IllegalArgumentException("viewModel not present");

        }
    }
}
