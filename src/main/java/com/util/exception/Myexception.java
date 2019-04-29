package com.util.exception;

public class Myexception extends RuntimeException {
    private  String message;
    public  Myexception(){

    }
    public  Myexception(String message){
        message = "xxxxxxxx哈哈";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
