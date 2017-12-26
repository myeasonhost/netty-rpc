package com.eason.rpc.common.annotation;

import java.lang.annotation.*;

/**
 * 客户端指定服务提供者
 * @author eason
 */
@Target({ ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ClientService {
    String address() default "";
    long  timeout() default 0;
}
