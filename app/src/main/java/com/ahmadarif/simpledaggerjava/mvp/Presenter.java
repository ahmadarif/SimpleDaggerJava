package com.ahmadarif.simpledaggerjava.mvp;

/**
 * Created by ARIF on 14-Jun-17.
 */

public interface Presenter<T extends View> {
    void onAttach(T view);
    void onDetach();
}
