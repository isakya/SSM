package com.izumi.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/***
 *
 *  1. �������У���Ҫͨ��ָ����ע�⽫������ʶλ֪ͨ����
 * @Before: ǰ��֪ͨ����ģ����󷽷�ִ��ǰִ��
 * @After: ����֪ͨ����Ŀ����󷽷���finally�����ִ�е�
 * @AfterReturning������֪ͨ����ģ�巽������ֵ֮��֪ͨ
 * @AfterThrowing: �쳣֪ͨ����Ŀ����󷽷���catch�־���ִ��
 *
 *
 * 2. �������ʽ�������ڱ�ʾ֪ͨ��ע���value������
 * execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))
 * execution(* com.izumi.spring.aop.annotation.*.*(..))
 * ��һ��* ��ʾ����ķ������η��ͷ���ֵ����
 * �ڶ���* ��ʾ��������ķ���
 * .. ��ʾ����Ĳ����б�
 * ��ķ���Ҳ������*����ʾ���µ�������
 *
 * 3. ��ȡ���ӵ����Ϣ
 * ��֪ͨ�����Ĳ���λ�ã�����JoinPoin���͵Ĳ������Ϳ��Ի�ȡ���ӵ�����Ӧ��������Ϣ
 *
 * // ��ȡ���ӵ�����Ӧ������ǩ����Ϣ
 * Signature signature = joinPoint.getSignature();
 * // ��ȡ���ӵ�����Ӧ�����Ĳ���
 * Object[] args = joinPoint.getArgs();
 *
 *
 * 4. �����������ʽ
 *  // @Pointcut����һ���������������ʽ
 *  @Pointcut("execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))")
 *  public void pointCut(){}
 *  // ʹ�÷�ʽ
 *  @Before("pointCut()")
 */

@Component
@Aspect // ����ǰ�����ʶλ����
public class LoggerAspect {
    @Pointcut("execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    // @Before("execution(public int com.izumi.spring.aop.annotation.CalculatorImpl.add(int, int))")
    // @Before("execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        // ��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        // ��ȡ���ӵ�����Ӧ�����Ĳ���
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect, ǰ��֪ͨ" + signature.getName() + ", ������" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        // ��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, ������ " + signature.getName() + " ִ�����");
    }

    /***
     *      �ڷ���֪ͨ����ӲҪ��ȡĿ����󷽷��ķ���ֵ��
     *      ֻ��Ҫͨ��@AfterReturningע���returning��
     *      �Ϳ��Խ�֪ͨ������ĳ������ָ��Ϊ����Ŀ����󷽷��ķ���ֵ�Ĳ�����
     *
     */

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, ����֪ͨ" + signature.getName() + "�������" + result);
    }


    /***
     *      �ڷ���֪ͨ����ӲҪ��ȡĿ����󷽷����쳣
     *      ֻ��Ҫͨ��@AfterThrowingע���throwing��
     *      �Ϳ��Խ�֪ͨ������ĳ������ָ��Ϊ����Ŀ����󷽷����ֵ��쳣�Ĳ�����
     *
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,������" + signature.getName() + ", �쳣֪ͨ��" + ex);
    }

    @Around("pointCut()")
    // ����֪ͨ�����ķ���ֵһ��Ҫ��Ŀ����󷽷��ķ���ֵһ��
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("����֪ͨ--> ǰ��֪ͨ");
            // ��ʾĿ�����Ŀ����󷽷���ִ��
            result = joinPoint.proceed();
            System.out.println("����֪ͨ--> ����֪ͨ");
        }catch (Throwable ex) {
            System.out.println("����֪ͨ--> �쳣֪ͨ");
        } finally {
            System.out.println("����֪ͨ--> ����֪ͨ");
        }
        return result;
    }
}
