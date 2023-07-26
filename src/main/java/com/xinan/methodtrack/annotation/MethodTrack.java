package com.xinan.methodtrack.annotation;

import java.lang.annotation.*;

/**
 * @author lilg
 * @date 2023/7/24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MethodTrack {
    String value() default "";

    Class<? extends Throwable>[] excludes() default {};
}
