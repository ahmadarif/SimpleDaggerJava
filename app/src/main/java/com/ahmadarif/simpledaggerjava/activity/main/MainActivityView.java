package com.ahmadarif.simpledaggerjava.activity.main;

import com.ahmadarif.simpledaggerjava.model.Response;
import com.ahmadarif.simpledaggerjava.mvp.View;

/**
 * Created by ARIF on 14-Jun-17.
 */

public interface MainActivityView extends View {

    void onLoadHelloSuccess(Response data);
    void onLoadHelloError(String data);

    void onLoadMessageSuccess(Response data);
    void onLoadMessageError(String data);

}
