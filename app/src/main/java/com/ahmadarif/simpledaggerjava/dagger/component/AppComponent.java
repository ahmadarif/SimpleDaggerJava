package com.ahmadarif.simpledaggerjava.dagger.component;

/**
 * Created by ARIF on 14-Jun-17.
 */

import android.app.Application;
import android.content.SharedPreferences;

import com.ahmadarif.simpledaggerjava.dagger.module.ApiModule;
import com.ahmadarif.simpledaggerjava.dagger.module.AppModule;
import com.ahmadarif.simpledaggerjava.dagger.module.NetworkModule;
import com.ahmadarif.simpledaggerjava.service.ApiService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        ApiModule.class
})
public interface AppComponent {
    Application application();
    SharedPreferences sharedPreferences();
    ApiService apiServive();
    @Named("Authorized") ApiService apiServiveAuth();
}
