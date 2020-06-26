package com.miracle.annotation;

import java.lang.annotation.*;

/**
 * @author Miracle
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictItem {

    String attr() default "";

    String item() default "";

    
}
