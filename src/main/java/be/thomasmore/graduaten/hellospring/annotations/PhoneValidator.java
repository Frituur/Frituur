package be.thomasmore.graduaten.hellospring.annotations;

import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


// Valideer of de telefoonnummer correct is
// Alleen nummer met +32, 13 cijfers, en digits
public class PhoneValidator  implements ConstraintValidator<PhoneNumberValidation, String> {
    @Override
    public void initialize(PhoneNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        // Check for digits
        return phoneNumber.startsWith("+32")
                && phoneNumber.length() == 13
                && NumberIsOnlyDigits(phoneNumber);
        // Filter out the first element and check if the string is a number

    }

    private boolean NumberIsOnlyDigits(String phonenumber) {
        // Stripe away the first element the +
        String number = phonenumber.substring(0);
        return tryParseNumber(number);
    }

    private boolean tryParseNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

