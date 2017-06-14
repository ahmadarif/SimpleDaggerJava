package com.ahmadarif.simpledaggerjava.dagger.component;

/**
 * Created by ARIF on 14-Jun-17.
 */

import com.ahmadarif.simpledaggerjava.activity.main.MainActivity;
import com.ahmadarif.simpledaggerjava.dagger.scope.MainActivityScope;

import dagger.Component;

@MainActivityScope
@Component(dependencies = {AppComponent.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}