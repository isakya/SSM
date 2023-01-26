package com.izumi.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/***
 *
 *  �������У���Ҫͨ��ָ����ע�⽫������ʶλ֪ͨ����
 * @Before: ǰ��֪ͨ����ģ����󷽷�ִ��ǰִ��
 *
 *
 */

@Component
@Aspect // ����ǰ�����ʶλ����
public class LoggerAspect {
    @Before("execution(public int com.izumi.spring.aop.annotation.CalculatorImpl.add(int, int))")
    public void beforeAdviceMethod() {
        System.out.println("LoggerAspect, ǰ��֪ͨ");
    }
}
