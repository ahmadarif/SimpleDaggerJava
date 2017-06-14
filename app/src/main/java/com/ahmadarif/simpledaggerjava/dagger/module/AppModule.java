package com.ahmadarif.simpledaggerjava.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ahmadarif.simpledaggerjava.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ARIF on 14-Jun-17.
 */
@Module
public class AppModule {

    App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application application() {
        return app;
    }

    @Provides
    @Singleton
    Context context() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences sharedPreferences(Application app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

}