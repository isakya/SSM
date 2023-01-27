package com.izumi.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/***
 *      ��������ȼ�
 *      ����ͨ��@Orderע���value�����������ȼ���Ĭ��ֵΪInteger�����ֵ
 *      @Order(1)ע���value������ֵԽС�����ȼ�Խ��
 */

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    // @Before("execution(* com.izumi.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.izumi.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod() {
        System.out.println("ValidateAspect--> ǰ��֪ͨ");
    }

}
