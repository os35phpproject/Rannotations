package Helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Alaa on 7/9/2018.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validator {
    int id() default 0;
    boolean required() default false;
    int min_length() default 0;
    int max_length() default 50;
    boolean only_numeric() default false;
    boolean is_email() default false;
    boolean is_trimable() default true;
}