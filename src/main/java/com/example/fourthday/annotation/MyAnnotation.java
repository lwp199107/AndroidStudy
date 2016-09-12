package com.example.fourthday.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Aslan on 2016/9/10.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    //--注解中有元素,元素以方法形式体现
    //--如果没有元素的注解被称为标记注解
    int getId() default 0;//这就是注解元素


}
