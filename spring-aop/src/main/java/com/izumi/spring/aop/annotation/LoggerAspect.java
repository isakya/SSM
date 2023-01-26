package com.izumi.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/***
 *
 *  1. 在切面中，需要通过指定的注解将方法标识位通知方法
 * @Before: 前置通知，在模板对象方法执行前执行
 *
 *
 * 2. 切入点表达式：设置在表示通知的注解的value属性中
 * execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))
 * execution(* com.izumi.spring.aop.annotation.*.*(..))
 * 第一个* 表示任意的访问修饰符和返回值类型
 * 第二个* 表示类中任意的方法
 * .. 表示任意的参数列表
 * 类的方法也可以用*，表示包下的所有类
 *
 * 3. 获取连接点的信息
 * 在通知方法的参数位置，设置JoinPoin类型的参数，就可以获取连接点所对应方法的信息
 *
 * // 获取连接点所对应方法的签名信息
 * Signature signature = joinPoint.getSignature();
 * // 获取连接点所对应方法的参数
 * Object[] args = joinPoint.getArgs();
 *
 *
 * 4. 重用切入点表达式
 *  // @Pointcut声明一个公共的切入点表达式
 *  @Pointcut("execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))")
 *  public void pointCut(){}
 *  // 使用方式
 *  @Before("pointCut()")
 */

@Component
@Aspect // 将当前组件标识位切面
public class LoggerAspect {
    @Pointcut("execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    // @Before("execution(public int com.izumi.spring.aop.annotation.CalculatorImpl.add(int, int))")
    // @Before("execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect, 前置通知" + signature.getName() + ", 参数：" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod() {

    }
}
