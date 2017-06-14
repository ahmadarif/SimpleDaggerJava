package com.ahmadarif.simpledaggerjava.model;

/**
 * Created by ARIF on 14-Jun-17.
 */

public class ResponseData<T> {

    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
