package com.opendevpro.exception;
import java.util.NoSuchElementException;

public class AutosNotFoundException extends NoSuchElementException {

    public AutosNotFoundException(String msj){
        super(msj);
    }
}
