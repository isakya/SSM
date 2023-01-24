package com.izumi.proxy;

import com.izumi.spring.proxy.CalculatorImpl;
import com.izumi.spring.proxy.CalculatorStaticProxy;
import org.junit.Test;

public class ProxyTest {
    @Test
    public  void testProxy() {
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }
} 
