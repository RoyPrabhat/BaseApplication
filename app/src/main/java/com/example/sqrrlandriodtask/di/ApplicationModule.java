package com.example.sqrrlandriodtask.di;

import android.app.Application;

import com.example.sqrrlandriodtask.base.MyApplication;
import com.example.sqrrlandriodtask.repository.DogsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    MyApplication provideMyApplication() {
        return application;
    }

    @Provides
    DogsRepository providesDogRepository() {
        return DogsRepository.getInstance();
    }
}
