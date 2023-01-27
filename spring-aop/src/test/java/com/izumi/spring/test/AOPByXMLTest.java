package com.izumi.spring.test;

import com.izumi.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByXMLTest {
    @Test
    public void testAOPByXML() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(1,1);
    }
}
