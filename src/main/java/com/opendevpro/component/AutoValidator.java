package com.opendevpro.component;

import com.opendevpro.model.Auto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class AutoValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Auto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Auto auto = (Auto) target;

        String errorCode = "empty or white space";

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "wheels", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doors", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxSpeed", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "engine", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "torque", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hp", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stock", errorCode);
//        errors.rejectValue("stock", "min");
    }
}
