package cap_software.hrms.core.validations;

import cap_software.hrms.entities.dtos.userDtos.EmplooyerDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailContainDomainSiteValidation implements ConstraintValidator<ValidEmailContainDomain,EmplooyerDto > {

    @Override
    public void initialize(ValidEmailContainDomain constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EmplooyerDto value, ConstraintValidatorContext context) {
        return false;
    }
}
