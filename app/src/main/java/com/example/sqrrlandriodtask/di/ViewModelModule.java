package com.example.sqrrlandriodtask.di;

import androidx.lifecycle.ViewModelProvider;

import com.example.sqrrlandriodtask.repository.DogsRepository;
import com.example.sqrrlandriodtask.viewmodel.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(DogsRepository repository){
        return new ViewModelFactory(repository);
    }
}
