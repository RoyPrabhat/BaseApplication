package com.example.sqrrlandriodtask.di;


import com.example.sqrrlandriodtask.view.breedlist.BreedListFragment;
import com.example.sqrrlandriodtask.view.imagelist.ImageListFragment;
import com.example.sqrrlandriodtask.viewmodel.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, ViewModelModule.class})
public interface ApplicationComponent {

    void inject(ImageListFragment imageListFragment);
    void inject(BreedListFragment breedListFragment);

}
