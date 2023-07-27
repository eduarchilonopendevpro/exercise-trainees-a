package com.opendevpro.utils;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {
    public static Map<String, Object> error(Exception e) {
        HashMap<String, Object> respuesta = new HashMap<>();
        respuesta.put("error", HttpStatus.INTERNAL_SERVER_ERROR);
        respuesta.put("message", e.getMessage());
        return respuesta;
    }

    public static Map<String, Object> ok(Object mensaje) {
        HashMap<String, Object> respuesta = new HashMap<>();
        respuesta.put("message", mensaje);
        return respuesta;
    }

    public static Map<String, Object> missing(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        HashMap<String, Object> respuesta = new HashMap<>();

        // Loop through the FieldError objects to get the names of missing properties
        for (FieldError fieldError : fieldErrors) {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            respuesta.put(fieldName, errorMessage);
        }
        return respuesta;
    }

    public static Map<String, Object> notFound(Object object) {
        HashMap<String, Object> respuesta = new HashMap<>();
        respuesta.put("message", object);
        return respuesta;
    }
}