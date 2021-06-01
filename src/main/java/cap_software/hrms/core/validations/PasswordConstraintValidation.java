package cap_software.hrms.core.validations;

import com.google.common.base.Joiner;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PasswordConstraintValidation implements ConstraintValidator<ValidPasswordConstraints,String> {

    @Override
    public void initialize(ValidPasswordConstraints constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        List<Rule> rules= new ArrayList<>();
        rules.add(new LengthRule(5,30));
        rules.add(new RepeatCharactersRule());
        rules.add(new UsernameRule());
        rules.add(new WhitespaceRule());

       PasswordValidator passwordValidator= new PasswordValidator(rules);
       RuleResult result =passwordValidator.validate(new PasswordData(password));

         if(result.isValid())
         {
             return true;
         }

         context.disableDefaultConstraintViolation();

         context.buildConstraintViolationWithTemplate(Joiner.on("\n")
                 .join(passwordValidator.getMessages(result))).addConstraintViolation();
        return false;



    }
}
