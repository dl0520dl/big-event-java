package com.dl.anno;

import com.dl.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.*;

@Documented//元注解
@Target({ElementType.FIELD})//元注解
@Retention(RetentionPolicy.RUNTIME)//元注解
@Constraint(validatedBy = {StateValidation.class})

public @interface State {
    //提供校验失败后的提示信息
    String message() default "state只能是已发布/草稿";

    //指定分组
    Class<?>[] groups() default {};

    //负载
    Class<? extends Payload>[] payload() default {};

}