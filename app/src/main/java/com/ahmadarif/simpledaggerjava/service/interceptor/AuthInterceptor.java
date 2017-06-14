package com.ahmadarif.simpledaggerjava.service.interceptor;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ARIF on 14-Jun-17.
 */
public class AuthInterceptor implements Interceptor {

    private final SharedPreferences pref;

    public AuthInterceptor(SharedPreferences pref) {
        this.pref = pref;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request original = chain.request();
        String token = pref.getString("token", null);

        if (token == null) return chain.proceed(original);

        Request.Builder builder = original.newBuilder()
                .header("Authorization", String.format("Bearer %s", token));
        Request request = builder.build();
        return chain.proceed(request);
    }

}