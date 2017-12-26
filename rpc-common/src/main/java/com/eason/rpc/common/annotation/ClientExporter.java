package com.eason.rpc.common.annotation;

import java.lang.annotation.*;

/**
 * @author eason
 */
@Target({ ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ClientExporter {
    //服务发现用的唯一标识，用于服务自动寻址
    String value() default "";
}
