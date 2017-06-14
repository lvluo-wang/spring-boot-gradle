package com.yx.statistics.common;

//定义的dao层扫描接口，dao层扫描给注解生成实现类
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Mapper {
    String value() default "";
}
