package com.ahmadarif.simpledaggerjava;

import android.app.Application;

import com.ahmadarif.simpledaggerjava.dagger.component.AppComponent;
import com.ahmadarif.simpledaggerjava.dagger.component.DaggerAppComponent;
import com.ahmadarif.simpledaggerjava.dagger.module.ApiModule;
import com.ahmadarif.simpledaggerjava.dagger.module.AppModule;
import com.ahmadarif.simpledaggerjava.dagger.module.NetworkModule;

/**
 * Created by ARIF on 14-Jun-17.
 */

public class App extends Application {

    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://adonis.daily-event.com/"))
                .apiModule(new ApiModule())
                .build();
    }

}