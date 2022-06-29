package be.thomasmore.graduaten.hellospring.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressValidator implements ConstraintValidator<AddressValidation, String> {
    @Override
    public void initialize(AddressValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //Om een geldig address te hebben moet de klant het volgende ingeven
        // postcode gemeente address nummmer

        return false;
    }
}
