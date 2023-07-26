package com.opendevpro.component;
import com.opendevpro.model.Venta;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class VentaValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Venta.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        String errorCode = "empty";

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaVenta", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cantidad", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comprador", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "autoId", errorCode);
    }
}
