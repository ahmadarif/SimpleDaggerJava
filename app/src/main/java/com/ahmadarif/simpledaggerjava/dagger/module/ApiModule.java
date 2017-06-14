package com.ahmadarif.simpledaggerjava.dagger.module;

import com.ahmadarif.simpledaggerjava.dagger.qualifier.Authorized;
import com.ahmadarif.simpledaggerjava.dagger.scope.AppScope;
import com.ahmadarif.simpledaggerjava.service.ApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ARIF on 14-Jun-17.
 */
@Module
public class ApiModule {

    @Provides
    @AppScope
    ApiService apiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @AppScope
    @Authorized
    ApiService apiServiceAuth(@Authorized Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}