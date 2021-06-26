package cap_software.hrms.core.validations;


import cap_software.hrms.core.dto.userDtos.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordMatchesValidation implements ConstraintValidator<ValidPasswordMatches,Object> {


    @Override
    public void initialize(ValidPasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);


    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        boolean result=true;

        if(value.getClass().getSuperclass()== UserDto.class)
        {
            UserDto userDto=(UserDto) value;



           // result=userDto.getPassword().equals(userDto.getMatchingPassword());
        }
        else
        {

        }
        return result;


    }
}
