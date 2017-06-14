package com.ahmadarif.simpledaggerjava.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ARIF on 14-Jun-17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MainActivityScope {}