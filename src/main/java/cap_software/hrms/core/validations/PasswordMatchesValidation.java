package cap_software.hrms.core.validations;


import cap_software.hrms.entities.dtos.userDtos.UserDto;

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

            System.out.println("girdi user sınıfını tanıdı");

            result=userDto.getPassword().equals(userDto.getMatchingPassword());
        }
        else
        {
            System.out.println("else gitfi  tanımadı");
        }
        return result;


    }
}
