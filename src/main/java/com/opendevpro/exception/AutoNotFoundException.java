package com.opendevpro.exception;
import java.util.NoSuchElementException;

public class AutoNotFoundException extends NoSuchElementException {

    private String message;

    public AutoNotFoundException(){
        this.message = "no existe el auto con el id";
    }

    @Override
    public String getMessage(){
        return this.message;
    }

}
