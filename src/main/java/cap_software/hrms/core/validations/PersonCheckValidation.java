package cap_software.hrms.core.validations;

import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckPersonService;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonCheckValidation implements ConstraintValidator<ValidRealPerson, PersonalInformation> {

    private CheckPersonService checkPersonService;
    @Override
    public void initialize(ValidRealPerson constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PersonalInformation value, ConstraintValidatorContext context) {
        return false;
    }
}
