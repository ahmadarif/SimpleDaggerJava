package com.ahmadarif.simpledaggerjava.dagger.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by ARIF on 14-Jun-17.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorized {}