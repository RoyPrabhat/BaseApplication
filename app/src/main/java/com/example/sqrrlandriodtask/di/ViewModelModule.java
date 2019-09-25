package com.example.sqrrlandriodtask.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.sqrrlandriodtask.viewmodel.BreedListViewModel;
import com.example.sqrrlandriodtask.viewmodel.ImageListViewModel;
import com.example.sqrrlandriodtask.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BreedListViewModel.class)
    abstract ViewModel bindBreedListViewModel(BreedListViewModel userViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ImageListViewModel.class)
    abstract ViewModel bindSearchViewModel(ImageListViewModel searchViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
