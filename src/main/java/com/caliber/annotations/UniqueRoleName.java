package com.caliber.annotations;

//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
//@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueRoleName {
    String message() default "RoleName already exists";
    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
}
