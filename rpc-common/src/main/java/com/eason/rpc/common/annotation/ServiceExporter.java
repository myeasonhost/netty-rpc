package com.eason.rpc.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 服务提供方发布服务的注解
 * @author eason
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Component
@Documented
public @interface ServiceExporter {
    //服务发现用的唯一标识，用于服务自动寻址
    String value() default "";
    Class<?> targetInterface(); //防止实现类实现了多个接口
}
