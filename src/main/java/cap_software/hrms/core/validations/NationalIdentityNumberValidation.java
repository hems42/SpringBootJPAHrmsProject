package cap_software.hrms.core.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NationalIdentityNumberValidation implements ConstraintValidator<ValidNationalIdentityNumber,String> {
    @Override
    public void initialize(ValidNationalIdentityNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
