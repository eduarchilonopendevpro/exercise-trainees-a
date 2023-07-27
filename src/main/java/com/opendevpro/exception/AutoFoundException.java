package com.opendevpro.exception;

public class AutoFoundException extends Exception{
    private String message;

    public AutoFoundException(){
        this.message = "ya existe un auto con esas propiedades";
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
