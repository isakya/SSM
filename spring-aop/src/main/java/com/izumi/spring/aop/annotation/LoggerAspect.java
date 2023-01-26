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
 *  1. �������У���Ҫͨ��ָ����ע�⽫������ʶλ֪ͨ����
 * @Before: ǰ��֪ͨ����ģ����󷽷�ִ��ǰִ��
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
    public void afterAdviceMethod() {

    }
}
