package cap_software.hrms.core.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(
        {ElementType.TYPE,
                ElementType.ANNOTATION_TYPE,
                ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NationalIdentityNumberValidation.class)
@Documented
public @interface ValidNationalIdentityNumber {

    String message() default "!! Not Valid Personal Identity Number...";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
