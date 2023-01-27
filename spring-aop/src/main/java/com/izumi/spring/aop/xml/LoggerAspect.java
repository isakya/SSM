package com.izumi.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class LoggerAspect {
    public void pointCut(){}


    public void beforeAdviceMethod(JoinPoint joinPoint) {
        // ��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        // ��ȡ���ӵ�����Ӧ�����Ĳ���
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect, ǰ��֪ͨ" + signature.getName() + ", ������" + Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        // ��ȡ���ӵ�����Ӧ������ǩ����Ϣ
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, ������ " + signature.getName() + " ִ�����");
    }


    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, ����֪ͨ" + signature.getName() + "�������" + result);
    }



    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,������" + signature.getName() + ", �쳣֪ͨ��" + ex);
    }


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
