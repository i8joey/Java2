package com.example.demo.validators;


import com.example.demo.domain.Part;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventoryRangeValidator implements ConstraintValidator<ValidInventoryRange, Part> {
    @Override
    public void initialize(ValidInventoryRange constraintAnnotation) {}

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        int inv = part.getInv();
        int min = part.getMinInv();
        int max = part.getMaxInv();
        boolean isValid = inv >= min && inv <= max;
        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid Inventory Range").addConstraintViolation();
        }
        return isValid;
    }
}
