package com.ahmadarif.simpledaggerjava.dagger.module;

import com.ahmadarif.simpledaggerjava.service.ApiService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ARIF on 14-Jun-17.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    ApiService apiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    @Named("Authorized")
    ApiService apiServiceAuth(@Named("Authorized") Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}