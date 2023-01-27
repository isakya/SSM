package com.izumi.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/***
 *
 *  1. 在切面中，需要通过指定的注解将方法标识位通知方法
 * @Before: 前置通知，在模板对象方法执行前执行
 * @After: 后置通知，在目标对象方法的finally语句中执行的
 * @AfterReturning：返回通知，在模板方法返回值之后通知
 * @AfterThrowing: 异常通知，在目标对象方法的catch字句中执行
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
    public void afterAdviceMethod(JoinPoint joinPoint) {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, 方法： " + signature.getName() + " 执行完毕");
    }

    /***
     *      在返回通知中若硬要获取目标对象方法的返回值，
     *      只需要通过@AfterReturning注解的returning，
     *      就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数。
     *
     */

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, 返回通知" + signature.getName() + "，结果：" + result);
    }


    /***
     *      在返回通知中若硬要获取目标对象方法的异常
     *      只需要通过@AfterThrowing注解的throwing，
     *      就可以将通知方法的某个参数指定为接收目标对象方法出现的异常的参数。
     *
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法：" + signature.getName() + ", 异常通知：" + ex);
    }

    @Around("pointCut()")
    // 环绕通知方法的返回值一定要和目标对象方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("环绕通知--> 前置通知");
            // 表示目标对象目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知--> 返回通知");
        }catch (Throwable ex) {
            System.out.println("环绕通知--> 异常通知");
        } finally {
            System.out.println("环绕通知--> 后置通知");
        }
        return result;
    }
}
