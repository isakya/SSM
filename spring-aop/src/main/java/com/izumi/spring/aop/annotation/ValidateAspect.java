package com.izumi.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/***
 *      切面的优先级
 *      可以通过@Order注解的value属性设置优先级，默认值为Integer的最大值
 *      @Order(1)注解的value的属性值越小，优先级越高
 */

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    // @Before("execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.izumi.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod() {
        System.out.println("ValidateAspect--> 前置通知");
    }

}
