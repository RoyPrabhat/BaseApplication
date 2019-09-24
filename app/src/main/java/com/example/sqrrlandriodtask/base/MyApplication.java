package com.example.sqrrlandriodtask.base;

import android.app.Application;

import com.example.sqrrlandriodtask.di.ApplicationComponent;
import com.example.sqrrlandriodtask.di.ApplicationModule;
import com.example.sqrrlandriodtask.di.DaggerApplicationComponent;

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
