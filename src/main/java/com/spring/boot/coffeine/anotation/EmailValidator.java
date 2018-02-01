package com.spring.boot.coffeine.anotation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom Annotation to validator
 * Created by hainguyen on 7/19/17.
 */
@Component
public class EmailValidator implements
        ConstraintValidator<EmailConstraint, String> {
    private static final String REGEX_EMAIl = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isValid(value);
    }
    public static boolean isValid(String value){
      return value.matches(REGEX_EMAIl);
    }
}
