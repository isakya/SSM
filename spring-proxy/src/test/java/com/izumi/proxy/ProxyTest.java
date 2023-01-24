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
         * 动态代理有两种：
         *  1. jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口
         *     生成的代理类在com.sun.proxy包下，类名为$proxy2
         *  2. cglib动态代理，最终生成的代理类会继承目标类，并且和目标类在相同的包下
         *
         */
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,3);
    }
} 
