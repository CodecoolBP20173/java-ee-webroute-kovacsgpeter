package com.codecool.webserver.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface WebRoute {
    String path() default "";
    String method() default "";
}
