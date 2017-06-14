package com.ahmadarif.simpledaggerjava.service;

import com.ahmadarif.simpledaggerjava.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ARIF on 14-Jun-17.
 */

public interface ApiService {

    @GET("api")
    Observable<Response> hello();

    @GET("api/message")
    Observable<Response> message();

}
