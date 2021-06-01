package cap_software.hrms.core.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(
        {ElementType.TYPE,
                ElementType.ANNOTATION_TYPE,
                ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstraintValidation.class)
@Documented
public @interface ValidPasswordConstraints {


    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
