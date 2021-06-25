package cap_software.hrms.core.validations;

import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;
import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PersonCheckValidation implements ConstraintValidator<ValidRealPerson, PersonalInformationDto> {

    private CheckValidPersonService checkValidPersonService;

    @Override
    public void initialize(ValidRealPerson constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PersonalInformationDto value, ConstraintValidatorContext context) {



        return   checkValidPersonService.isValidPerson(value.getNationalIdentityNumber(),
                value.getName(),
                value.getSurname(),
                String.valueOf(value.getBirthOfDate().getYear()));
    }
}
