package com.izumi.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/***
 *
 *  在切面中，需要通过指定的注解将方法标识位通知方法
 * @Before: 前置通知，在模板对象方法执行前执行
 *
 *
 */

@Component
@Aspect // 将当前组件标识位切面
public class LoggerAspect {
    @Before("execution(public int com.izumi.spring.aop.annotation.CalculatorImpl.add(int, int))")
    public void beforeAdviceMethod() {
        System.out.println("LoggerAspect, 前置通知");
    }
}
