package com.ahmadarif.simpledaggerjava.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ahmadarif.simpledaggerjava.App;
import com.ahmadarif.simpledaggerjava.dagger.scope.AppScope;

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
    @AppScope
    Application application() {
        return app;
    }

    @Provides
    @AppScope
    Context context() {
        return app.getApplicationContext();
    }

    @Provides
    @AppScope
    SharedPreferences sharedPreferences(Application app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

}