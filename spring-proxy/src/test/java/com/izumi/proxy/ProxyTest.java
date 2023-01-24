package com.izumi.proxy;

import com.izumi.spring.proxy.Calculator;
import com.izumi.spring.proxy.CalculatorImpl;
import com.izumi.spring.proxy.CalculatorStaticProxy;
import com.izumi.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
    @Test
    public  void testProxy() {
        // CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        // proxy.add(1,2);

        /***
         * ��̬���������֣�
         *  1. jdk��̬����Ҫ������нӿڣ��������ɵĴ������Ŀ����ʵ����ͬ�Ľӿ�
         *     ���ɵĴ�������com.sun.proxy���£�����Ϊ$proxy2
         *  2. cglib��̬�����������ɵĴ������̳�Ŀ���࣬���Һ�Ŀ��������ͬ�İ���
         *
         */
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,3);
    }
} 
