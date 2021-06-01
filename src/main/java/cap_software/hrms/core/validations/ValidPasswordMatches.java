package cap_software.hrms.core.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(
        {ElementType.TYPE,
            ElementType.ANNOTATION_TYPE,
            ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidation.class)
@Documented
public @interface ValidPasswordMatches {

    String message() default "!! Not matching passwords";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
