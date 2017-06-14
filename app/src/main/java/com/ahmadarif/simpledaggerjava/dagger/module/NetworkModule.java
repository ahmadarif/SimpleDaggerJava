package com.ahmadarif.simpledaggerjava.dagger.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.ahmadarif.simpledaggerjava.BuildConfig;
import com.ahmadarif.simpledaggerjava.dagger.qualifier.Authorized;
import com.ahmadarif.simpledaggerjava.dagger.scope.AppScope;
import com.ahmadarif.simpledaggerjava.service.interceptor.AuthInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ARIF on 14-Jun-17.
 */

@Module
public class NetworkModule {

    String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @AppScope
    Cache cache(Application app) {
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        return new Cache(app.getCacheDir(), cacheSize);
    }

    @Provides
    @AppScope
    HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return interceptor;
    }

    @Provides
    @AppScope
    OkHttpClient httpClient(HttpLoggingInterceptor logger, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(logger);
        builder.cache(cache);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        return builder.build();
    }

    @Provides
    @AppScope
    Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @AppScope
    @Authorized
    OkHttpClient httpClientAuth(HttpLoggingInterceptor logger, Cache cache, SharedPreferences pref) {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(new AuthInterceptor(pref));
        builder.addInterceptor(logger);
        builder.cache(cache);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        return builder.build();
    }

    @Provides
    @AppScope
    @Authorized
    Retrofit retrofitAuth(@Authorized OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}