package cap_software.hrms.core.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(
        {ElementType.TYPE,
                ElementType.ANNOTATION_TYPE,
                ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailContainDomainSiteValidation.class)
@Documented
public @interface ValidContainDomainEmail {

    String message() default "!! Email not contain website domain";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
