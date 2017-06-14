package com.ahmadarif.simpledaggerjava.activity.main;

import android.content.SharedPreferences;

import com.ahmadarif.simpledaggerjava.dagger.qualifier.Authorized;
import com.ahmadarif.simpledaggerjava.model.Response;
import com.ahmadarif.simpledaggerjava.mvp.Presenter;
import com.ahmadarif.simpledaggerjava.service.ApiService;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ARIF on 14-Jun-17.
 */

public class MainActivityPresenter implements Presenter<MainActivityView> {

    private MainActivityView view = null;

    private final ApiService api;
    private final SharedPreferences pref;

    @Inject
    public MainActivityPresenter(@Authorized ApiService api, SharedPreferences pref) {
        this.api = api;
        this.pref = pref;
    }

    @Override
    public void onAttach(MainActivityView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    public void loadHello() {
        api.hello()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull Response response) {
                        view.onLoadHelloSuccess(response);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.onLoadHelloError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {}
                });
    }

    void loadMessage() {
        api.message()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull Response response) {
                        view.onLoadMessageSuccess(response);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.onLoadMessageError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {}
                });
    }

}