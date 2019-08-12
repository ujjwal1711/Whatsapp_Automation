package com.clicdirectory.entity;

/**
 * Created by hackme on 12/13/18.
 */
public class ResponseMessage<T>{

    public String message;
    public String type;
    public T data;

    public ResponseMessage(String message, String type, T data) {
        this.message = message;
        this.type = type;
        this.data = data;
    }

}
